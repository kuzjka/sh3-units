import { Component } from '@angular/core';
import { UnitsService } from "../../core/units.service";
import { MatDialog } from "@angular/material/dialog";
import { MatSnackBar } from "@angular/material/snack-bar";
import { Observable } from "rxjs";
import { Aircraft, NationEntry, UnitEntry } from "../../core/data.model";
import { AircraftAddComponent } from "../aircraft-add/aircraft-add.component";
import { AircraftItemComponent } from "../aircraft-item/aircraft-item.component";
import { FormBuilder } from "@angular/forms";

@Component({
  selector: 'app-aircraft-list',
  templateUrl: './aircraft-list.component.html',
  styleUrls: ['./aircraft-list.component.css']
})
export class AircraftListComponent {
  editable: Observable<boolean>;

  aircraft: UnitEntry<Aircraft>[] = [];

  backendFilters = this.fb.group({
    year: this.fb.control<number | null>(null),
    nations: this.fb.nonNullable.control([] as string[])
  });

  nations: NationEntry[] = [];

  constructor(private unitService: UnitsService,
              private dialog: MatDialog,
              private snackBar: MatSnackBar,
              private fb: FormBuilder) {
    this.editable = unitService.isEditable();
    this.loadAircraft();
    unitService.getNations().subscribe(data => this.nations = data);
    this.backendFilters.valueChanges.subscribe(() => this.loadAircraft());
  }

  loadAircraft() {
    const filters = this.backendFilters.getRawValue();
    this.unitService.getAircraft(filters.year || undefined, filters.nations).subscribe({
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
