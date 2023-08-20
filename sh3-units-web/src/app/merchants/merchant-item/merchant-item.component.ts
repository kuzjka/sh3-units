import { Component, Inject } from '@angular/core';
import { Merchant, UnitEntry } from "../../core/data.model";
import { MAT_DIALOG_DATA, MatDialogRef } from "@angular/material/dialog";

@Component({
  selector: 'app-merchant-item',
  templateUrl: './merchant-item.component.html',
  styleUrls: ['./merchant-item.component.css']
})
export class MerchantItemComponent {
  merchant!: UnitEntry<Merchant>;

  constructor(@Inject(MAT_DIALOG_DATA) merchant: UnitEntry<Merchant>,
              private dialogRef: MatDialogRef<MerchantItemComponent>) {
    this.merchant = merchant;
  }

  close() {
    this.dialogRef.close();
  }
}
