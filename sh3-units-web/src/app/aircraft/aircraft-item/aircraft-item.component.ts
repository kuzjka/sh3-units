import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from "@angular/material/dialog";
import { Aircraft, UnitEntry } from "../../shared/data.model";

@Component({
  selector: 'app-aircraft-item',
  templateUrl: './aircraft-item.component.html',
  styleUrls: ['./aircraft-item.component.css']
})
export class AircraftItemComponent {
  aircraft: UnitEntry<Aircraft>;

  constructor(@Inject(MAT_DIALOG_DATA) aircraft: UnitEntry<Aircraft>,
              private dialogRef: MatDialogRef<AircraftItemComponent>) {
    this.aircraft = aircraft;
  }

  close() {
    this.dialogRef.close();
  }
}
