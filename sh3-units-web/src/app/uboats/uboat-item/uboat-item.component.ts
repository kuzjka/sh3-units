import { Component, Inject } from '@angular/core';
import { UBoat, UnitEntry } from "../../shared/data.model";
import { MAT_DIALOG_DATA, MatDialogRef } from "@angular/material/dialog";

@Component({
  selector: 'app-uboat-item',
  templateUrl: './uboat-item.component.html',
  styleUrls: ['./uboat-item.component.css']
})
export class UboatItemComponent {
  uboat: UnitEntry<UBoat>;

  constructor(@Inject(MAT_DIALOG_DATA) uboat: UnitEntry<UBoat>,
              private dialogRef: MatDialogRef<UboatItemComponent>) {
    this.uboat = uboat;
  }

  close() {
    this.dialogRef.close();
  }
}
