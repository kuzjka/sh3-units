import { Component } from '@angular/core';
import { Observable } from "rxjs";
import { UnitEntry, Warship } from "../../shared/data.model";
import { UnitsService } from "../../shared/units.service";
import { MatDialog } from "@angular/material/dialog";
import { MatSnackBar } from "@angular/material/snack-bar";
import { WarshipAddComponent } from "../warship-add/warship-add.component";
import { WarshipItemComponent } from "../warship-item/warship-item.component";

@Component({
  selector: 'app-warship-list',
  templateUrl: './warship-list.component.html',
  styleUrls: ['./warship-list.component.css']
})
export class WarshipListComponent {
  editable: Observable<boolean>;

  warships: UnitEntry<Warship>[] = [];

  constructor(private unitsService: UnitsService,
              private dialog: MatDialog,
              private snackBar: MatSnackBar) {
    this.editable = this.unitsService.isEditable();
    this.loadWarships();
  }

  loadWarships() {
    this.unitsService.getWarships().subscribe({
      next: data => this.warships = data,
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
}
