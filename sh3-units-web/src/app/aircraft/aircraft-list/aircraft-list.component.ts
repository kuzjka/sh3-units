import { Component } from '@angular/core';
import { UnitsService } from "../../shared/units.service";
import { MatDialog } from "@angular/material/dialog";
import { MatSnackBar } from "@angular/material/snack-bar";
import { Observable } from "rxjs";
import { Aircraft, UnitEntry } from "../../shared/data.model";
import { AircraftAddComponent } from "../aircraft-add/aircraft-add.component";
import { AircraftItemComponent } from "../aircraft-item/aircraft-item.component";

@Component({
  selector: 'app-aircraft-list',
  templateUrl: './aircraft-list.component.html',
  styleUrls: ['./aircraft-list.component.css']
})
export class AircraftListComponent {
  editable: Observable<boolean>;

  aircraft: UnitEntry<Aircraft>[] = [];

  constructor(private unitService: UnitsService,
              private dialog: MatDialog,
              private snackBar: MatSnackBar) {
    this.editable = unitService.isEditable();
    this.loadAircraft();
  }

  loadAircraft() {
    this.unitService.getAircraft().subscribe({
      next: data => this.aircraft = data,
      error: () => this.snackBar.open('Cannot get aircraft')
    });
  }

  openAddDialog() {
    const dialogRef = this.dialog.open(AircraftAddComponent, { minWidth: 480 });

    dialogRef.afterClosed().subscribe(added => {
      if (added) this.loadAircraft();
    });
  }

  openItemDetails(aircraft: UnitEntry<Aircraft>) {
    this.dialog.open(AircraftItemComponent, { data: aircraft });
  }

}
