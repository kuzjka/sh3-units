import { Component } from '@angular/core';
import { filter, Observable } from "rxjs";
import { Merchant, NationEntry, UnitEntry, Warship, WarshipCategory } from "../../core/data.model";
import { UnitsService } from "../../core/units.service";
import { MatDialog } from "@angular/material/dialog";
import { MatSnackBar } from "@angular/material/snack-bar";
import { WarshipAddComponent } from "../warship-add/warship-add.component";
import { WarshipItemComponent } from "../warship-item/warship-item.component";
import { FormBuilder } from "@angular/forms";

enum SortOptions {
  Name = 'Name',
  Displacement = 'Displacement'
}

@Component({
  selector: 'app-warship-list',
  templateUrl: './warship-list.component.html',
  styleUrls: ['./warship-list.component.css']
})
export class WarshipListComponent {
  CATEGORIES = Object.values(WarshipCategory);
  SORT_OPTIONS = Object.values(SortOptions);

  editable: Observable<boolean>;

  warships: UnitEntry<Warship>[] = []
  filteredWarships: UnitEntry<Warship>[] = [];

  backendFilters = this.fb.group({
    year: this.fb.control<number | null>(null),
    nations: this.fb.nonNullable.control([] as string[])
  });

  frontendFilters = this.fb.nonNullable.group({
    categories: this.fb.nonNullable.control<WarshipCategory[]>([]),
    sortOption: SortOptions.Name,
    sortOrderAsc: true,
  });

  nations: NationEntry[] = [];

  constructor(private unitsService: UnitsService,
              private dialog: MatDialog,
              private snackBar: MatSnackBar,
              private fb: FormBuilder) {
    this.editable = this.unitsService.isEditable();
    unitsService.getNations().subscribe(data => this.nations = data);
    this.loadWarships();
    this.backendFilters.valueChanges.subscribe(() => this.loadWarships());
    this.frontendFilters.valueChanges.subscribe(() => {
      this.filteredWarships = this.applyFrontendFilters(this.warships);
    })
  }

  loadWarships() {
    const filters = this.backendFilters.getRawValue();
    this.unitsService.getWarships(filters.year || undefined, filters.nations).subscribe({
      next: data => {
        this.warships = data;
        this.filteredWarships = this.applyFrontendFilters(data);
      },
      error: () => this.snackBar.open("Cannot get warships")
    });
  }

  openAddDialog() {
    const dialogRef = this.dialog.open(WarshipAddComponent, { minWidth: 480 });

    dialogRef.afterClosed().subscribe(added => {
      if (added) this.loadWarships();
    });
  }

  openItemDetails(warship: UnitEntry<Warship>) {
    this.dialog.open(WarshipItemComponent, { data: warship });
  }

  private applyFrontendFilters(warships: UnitEntry<Warship>[]): UnitEntry<Warship>[] {
    const filters = this.frontendFilters.getRawValue();

    const result = filters.categories.length > 0 ?
      warships.filter(v => filters.categories.includes(v.unit.category)) : warships;

    result.sort((left, right) => {
      switch (filters.sortOption) {
        case SortOptions.Name: return left.unit.name.localeCompare(right.unit.name);
        case SortOptions.Displacement: return left.unit.displacement - right.unit.displacement;
      }
    });

    if (!filters.sortOrderAsc) result.reverse();

    return result;
  }
}
