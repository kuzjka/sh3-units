import { Component } from '@angular/core';
import { Observable } from "rxjs";
import { UBoat, UnitEntry } from "../../shared/data.model";
import { UnitsService } from "../../shared/units.service";
import { MatDialog } from "@angular/material/dialog";
import { MatSnackBar } from "@angular/material/snack-bar";
import { UboatAddComponent } from "../uboat-add/uboat-add.component";
import { UboatItemComponent } from "../uboat-item/uboat-item.component";

@Component({
  selector: 'app-uboat-list',
  templateUrl: './uboat-list.component.html',
  styleUrls: ['./uboat-list.component.css']
})
export class UboatListComponent {
  editable: Observable<boolean>;

  uboats: UnitEntry<UBoat>[] = [];

  constructor(private unitService: UnitsService,
              private dialog: MatDialog,
              private snackBar: MatSnackBar) {
    this.editable = unitService.isEditable();
    this.loadUboats();
  }

  loadUboats() {
    this.unitService.getUboats().subscribe({
      next: data => this.uboats = data,
      error: () => this.snackBar.open('Cannot get uboats')
    });
  }

  openAddDialog() {
    const dialogRef = this.dialog.open(UboatAddComponent, { minWidth: 400 });

    dialogRef.afterClosed().subscribe(added => {
      if (added) this.loadUboats();
    });
  }

  openItemDetails(uboat: UnitEntry<UBoat>) {
    this.dialog.open(UboatItemComponent, { data: uboat });
  }
}
