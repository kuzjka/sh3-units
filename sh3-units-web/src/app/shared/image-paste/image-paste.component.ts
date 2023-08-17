import { Component, EventEmitter, Output } from '@angular/core';
import { Observable } from "rxjs";
import { MatSnackBar } from "@angular/material/snack-bar";

const PNG_TYPE = 'image/png'

@Component({
  selector: 'app-image-paste',
  templateUrl: './image-paste.component.html',
  styleUrls: ['./image-paste.component.css']
})
export class ImagePasteComponent {
  @Output('imageLoaded')
  imageOutput = new EventEmitter<ArrayBuffer>();

  previewSrc?: string;

  maxSize = 64;

  constructor(private snackBar: MatSnackBar) {}

  paste(e: ClipboardEvent) {
    if (!e.clipboardData) return;
    for (let i = 0; i < e.clipboardData.items.length; i++) {
      if (e.clipboardData.items[i].type === PNG_TYPE) {
        const blob = e.clipboardData.items[i].getAsFile();
        if (blob != null) {
          const imageSrc = URL.createObjectURL(blob);
          this.getPreview(imageSrc).subscribe({
            next: previewSrc => this.previewSrc = previewSrc,
            error: () => this.snackBar.open('Cannot show image preview')
          });
          blob.arrayBuffer().then(value => this.imageOutput.emit(value));
        }
      }
    }
  }

  getPreview(imageSrc: string): Observable<string> {
    return new Observable<string>(subscriber => {
      const original = new Image();
      original.src = imageSrc;
      original.onload = () => {
        const ratio = this.maxSize / Math.max(original.height, original.width);
        const newHeight = Math.round(original.height * ratio);
        const newWidth = Math.round(original.width * ratio);
        const canvas = document.createElement('canvas');
        canvas.width = newWidth;
        canvas.height = newHeight;
        const ctx = canvas.getContext('2d');
        if (!ctx) {
          subscriber.error("Cannot get canvas context");
          subscriber.complete();
          return;
        }
        ctx.drawImage(original, 0, 0, newWidth, newHeight);
        subscriber.next(ctx.canvas.toDataURL('image/png'));
        subscriber.complete();
      }
      original.onerror = e => {
        subscriber.error(e);
        subscriber.complete();
      }
    });
  }
}
