import { Component } from '@angular/core';
import { FormBuilder, Validators } from "@angular/forms";
import { MatDialogRef } from "@angular/material/dialog";
import { NationsService } from "../nations.service";
import { MatSnackBar } from "@angular/material/snack-bar";

@Component({
  selector: 'app-nation-add',
  templateUrl: './nation-add.component.html',
  styleUrls: ['./nation-add.component.css']
})
export class NationAddComponent {
  name = this.fb.nonNullable.control('', Validators.required);

  image?: ArrayBuffer

  constructor(private fb: FormBuilder,
              private dialogRef: MatDialogRef<NationAddComponent>,
              private nationsService: NationsService,
              private snackBar: MatSnackBar) {
  }

  submit() {
    if (!this.name.valid || !this.image) return;

    this.nationsService.addNation(this.name.value, this.image).subscribe({
      next: () => this.dialogRef.close(true),
      error: () => this.snackBar.open('Cannot add nation')
    });
  }

  cancel() {
    this.dialogRef.close(false);
  }

  imageLoaded(image: ArrayBuffer) {
    this.image = image;
  }
}
