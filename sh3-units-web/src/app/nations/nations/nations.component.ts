import { Component, ViewChild } from '@angular/core';
import { MatDialog } from "@angular/material/dialog";
import { NationAddComponent } from "../nation-add/nation-add.component";
import { NationEntry } from "../../core/data.model";
import { UnitsService } from "../../core/units.service";
import { MatSnackBar } from "@angular/material/snack-bar";
import { NationOrdersComponent } from "../nation-orders/nation-orders.component";

@Component({
  selector: 'app-nations',
  templateUrl: './nations.component.html',
  styleUrls: ['./nations.component.css']
})
export class NationsComponent {
  nations: NationEntry[] = [];
  selectedNation?: NationEntry;

  @ViewChild(NationOrdersComponent)
  ordersComponentElement!: NationOrdersComponent;

  constructor(private unitService: UnitsService,
              private dialog: MatDialog,
              private snackBar: MatSnackBar) {
    this.loadNations();
  }

  openAddNationDialog() {
    const dialogRef = this.dialog.open(NationAddComponent, { minWidth: 480 });

    dialogRef.afterClosed().subscribe(added => {
      if (added) this.loadNations();
    })
  }

  loadNations() {
    this.unitService.getNations().subscribe({
      next: data => this.nations = data,
      error: () => this.snackBar.open('Cannot get nations')
    });
  }
}
