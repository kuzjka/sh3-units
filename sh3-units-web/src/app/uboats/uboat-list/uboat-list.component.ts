import { Component } from '@angular/core';
import { Observable } from "rxjs";
import { NationEntry, UBoat, UnitEntry } from "../../core/data.model";
import { UnitsService } from "../../core/units.service";
import { MatDialog } from "@angular/material/dialog";
import { MatSnackBar } from "@angular/material/snack-bar";
import { UboatAddComponent } from "../uboat-add/uboat-add.component";
import { UboatItemComponent } from "../uboat-item/uboat-item.component";
import { FormBuilder } from "@angular/forms";

@Component({
  selector: 'app-uboat-list',
  templateUrl: './uboat-list.component.html',
  styleUrls: ['./uboat-list.component.css']
})
export class UboatListComponent {
  editable: Observable<boolean>;

  uboats: UnitEntry<UBoat>[] = [];

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
    unitService.getNations().subscribe(data => this.nations = data);
    this.loadUboats();
    this.backendFilters.valueChanges.subscribe(() => this.loadUboats());
  }

  loadUboats() {
    const filters = this.backendFilters.getRawValue();
    this.unitService.getUboats(filters.year || undefined, filters.nations).subscribe({
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
