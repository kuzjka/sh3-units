import { Component } from '@angular/core';
import { UnitsService } from "../../shared/units.service";
import { Observable } from "rxjs";
import { Merchant, UnitEntry } from "../../shared/data.model";
import { MatDialog } from "@angular/material/dialog";
import { MatSnackBar } from "@angular/material/snack-bar";
import { MerchantAddComponent } from "../merchant-add/merchant-add.component";
import { ImageViewComponent } from "../../shared/image-view/image-view.component";

@Component({
  selector: 'app-merchant-list',
  templateUrl: './merchant-list.component.html',
  styleUrls: ['./merchant-list.component.css']
})
export class MerchantListComponent {
  editable: Observable<boolean>;

  merchants: UnitEntry<Merchant>[] = [];

  constructor(private unitsService: UnitsService,
              private dialog: MatDialog,
              private snackBar: MatSnackBar) {
    this.editable = unitsService.isEditable();
    this.loadMerchants();
  }

  loadMerchants() {
    this.unitsService.getMerchants().subscribe({
      next: (data) => this.merchants = data,
      error: () => this.snackBar.open("Cannot get merchants")
    });
  }

  openAddDialog() {
    const dialogRef = this.dialog.open(MerchantAddComponent, { minWidth: 480 });

    dialogRef.afterClosed().subscribe(added => {
      if (added) this.loadMerchants();
    });
  }


}
