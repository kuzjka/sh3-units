import { Component, Input } from '@angular/core';
import { Merchant, UnitEntry } from "../../shared/data.model";
import { ImageViewComponent } from "../../shared/image-view/image-view.component";
import { MatDialog } from "@angular/material/dialog";

@Component({
  selector: 'app-merchant-item',
  templateUrl: './merchant-item.component.html',
  styleUrls: ['./merchant-item.component.css']
})
export class MerchantItemComponent {
  @Input({ required: true })
  merchant!: UnitEntry<Merchant>;

  constructor(private dialog: MatDialog) {}

  openImage(imageSrc: string) {
    this.dialog.open(ImageViewComponent, { data: imageSrc });
  }
}
