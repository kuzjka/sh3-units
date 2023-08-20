import { Component, Input, Output } from '@angular/core';
import { NationEntry } from "../../core/data.model";
import { OrderOfBattle, Presence, UnitSelectionEntry } from "../nations.model";
import { OrderModel } from "./order-model.model";
import { NationsService } from "../nations.service";
import { MatSnackBar } from "@angular/material/snack-bar";

@Component({
  selector: 'app-nation-orders',
  templateUrl: './nation-orders.component.html',
  styleUrls: ['./nation-orders.component.css']
})
export class NationOrdersComponent {
  private _nationEntry?: NationEntry;
  model: OrderModel = new OrderModel();

  merchantList: UnitSelectionEntry[] = [];
  warshipList: UnitSelectionEntry[] = [];
  uboatList: UnitSelectionEntry[] = [];
  aircraftList: UnitSelectionEntry[] = [];

  constructor(private nationService: NationsService,
              private snackBar: MatSnackBar) {
    this.nationService.getMerchantSelection().subscribe({
      next: data=> this.merchantList = data,
      error: () => this.notifySelectionError('merchant')
    });

    this.nationService.getWarshipSelection().subscribe({
      next: data => this.warshipList = data,
      error: () => this.notifySelectionError('warship')
    });

    this.nationService.getUboatSelection().subscribe({
      next: data => this.uboatList = data,
      error: () => this.notifySelectionError('uboat')
    });

    this.nationService.getAircraftSelection().subscribe({
      next: data => this.aircraftList = data,
      error: () => this.notifySelectionError('aircraft')
    });
  }

  @Input()
  public set nationEntry(entry: NationEntry | undefined) {
    this._nationEntry = entry;
    if (entry) {
      this.model = new OrderModel();
    }
  }

  public get nationEntry(): NationEntry | undefined {
    return this._nationEntry;
  }

  submit() {
    if (!this.nationEntry) return;

    const order: OrderOfBattle = {
      nationId: this.nationEntry.id,
      merchants: this.model.getMerchantPresences(),
      warships: this.model.getWarshipPresences(),
      uboats: this.model.getUboatPresences(),
      aircraft: this.model.getAircraftPresences()
    };

    this.nationService.saveOrderOfBattle(order).subscribe({
      next: () => this.snackBar.open("Order of battle successfully saved"),
      error: () => this.snackBar.open("Couldn't save order of battle")
    });
  }

  private notifySelectionError(listName: string) {
    this.snackBar.open(`Cannot get ${listName} selection list`);
  }
}
