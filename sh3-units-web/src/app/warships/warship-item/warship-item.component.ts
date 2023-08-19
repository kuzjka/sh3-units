import { Component, Inject } from '@angular/core';
import { UnitEntry, Warship } from "../../shared/data.model";
import { MAT_DIALOG_DATA, MatDialogRef } from "@angular/material/dialog";

@Component({
  selector: 'app-warship-item',
  templateUrl: './warship-item.component.html',
  styleUrls: ['./warship-item.component.css']
})
export class WarshipItemComponent {
  warship: UnitEntry<Warship>;

  constructor(@Inject(MAT_DIALOG_DATA) warship: UnitEntry<Warship>,
              private dialogRef: MatDialogRef<WarshipItemComponent>) {
    this.warship = warship;
  }

  close() {
    this.dialogRef.close();
  }
}
