import { Component, Input } from '@angular/core';
import { OrderModelEntry } from "../order-model.model";

@Component({
  selector: 'app-nation-order-entry',
  templateUrl: './nation-order-entry.component.html',
  styleUrls: ['./nation-order-entry.component.css']
})
export class NationOrderEntryComponent {
  @Input({ required: true })
  entry!: OrderModelEntry;
}
