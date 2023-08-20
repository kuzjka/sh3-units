import { Component, EventEmitter, Input, Output } from '@angular/core';
import { UnitSelectionEntry } from "../../nations.model";
import { FormControl } from "@angular/forms";

@Component({
  selector: 'app-nation-order-selector',
  templateUrl: './nation-order-selector.component.html',
  styleUrls: ['./nation-order-selector.component.css']
})
export class NationOrderSelectorComponent {
  @Input({ required: true })
  selectionList!: UnitSelectionEntry[];

  @Output()
  selected = new EventEmitter<UnitSelectionEntry>();

  control = new FormControl<UnitSelectionEntry | null>(null);

  constructor() {
    this.control.valueChanges.subscribe(val => {
      if (val) {
        this.selected.emit(val);
        this.control.setValue(null);
      }
    });
  }
}
