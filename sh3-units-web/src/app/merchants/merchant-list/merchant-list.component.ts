import { Component } from '@angular/core';
import { UnitsService } from "../../core/units.service";
import { filter, Observable } from "rxjs";
import { Merchant, MerchantCategory, NationEntry, UnitEntry } from "../../core/data.model";
import { MatDialog } from "@angular/material/dialog";
import { MatSnackBar } from "@angular/material/snack-bar";
import { MerchantAddComponent } from "../merchant-add/merchant-add.component";
import { MerchantItemComponent } from "../merchant-item/merchant-item.component";
import { FormBuilder } from "@angular/forms";

enum SortOptions {
  Name = "Name",
  Displacement = "Displacement"
}

@Component({
  selector: 'app-merchant-list',
  templateUrl: './merchant-list.component.html',
  styleUrls: ['./merchant-list.component.css']
})
export class MerchantListComponent {
  SORT_OPTIONS = Object.values(SortOptions);
  CATEGORIES = Object.values(MerchantCategory);

  editable: Observable<boolean>;

  merchants: UnitEntry<Merchant>[] = [];
  filteredMerchants: UnitEntry<Merchant>[] = [];

  backendFilters = this.fb.group({
    year: this.fb.control<number | null>(null),
    nations: this.fb.nonNullable.control([] as string[])
  });

  frontendFilters = this.fb.nonNullable.group({
    categories: this.fb.nonNullable.control<MerchantCategory[]>([]),
    sortOption: SortOptions.Name,
    sortOrderAsc: true,
  });

  nations: NationEntry[] = [];

  constructor(private unitsService: UnitsService,
              private dialog: MatDialog,
              private snackBar: MatSnackBar,
              private fb: FormBuilder) {
    this.editable = unitsService.isEditable();
    unitsService.getNations().subscribe(data => this.nations = data);
    this.loadMerchants();
    this.backendFilters.valueChanges.subscribe(() => this.loadMerchants());
    this.frontendFilters.valueChanges.subscribe(() =>
      this.filteredMerchants = this.applyFrontendFilters(this.merchants));
  }

  loadMerchants() {
    const filters = this.backendFilters.getRawValue();
    this.unitsService.getMerchants(filters.year || undefined, filters.nations).subscribe({
      next: (data) => {
        this.merchants = data;
        this.filteredMerchants = this.applyFrontendFilters(data);
      },
      error: () => this.snackBar.open("Cannot get merchants")
    });
  }

  openAddDialog() {
    const dialogRef = this.dialog.open(MerchantAddComponent, { minWidth: 480 });

    dialogRef.afterClosed().subscribe(added => {
      if (added) this.loadMerchants();
    });
  }

  openItemDetails(merchant: UnitEntry<Merchant>) {
    this.dialog.open(MerchantItemComponent, { data: merchant });
  }

  private applyFrontendFilters(merchants: UnitEntry<Merchant>[]): UnitEntry<Merchant>[] {
    const filters = this.frontendFilters.getRawValue();

    const result = filters.categories.length > 0 ?
      merchants.filter(v => filters.categories.includes(v.unit.category)) : merchants;

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
