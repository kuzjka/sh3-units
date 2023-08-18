import { Component, Input } from '@angular/core';
import { Merchant, UnitEntry } from "../../shared/data.model";

@Component({
  selector: 'app-merchant-card',
  templateUrl: './merchant-card.component.html',
  styleUrls: ['./merchant-card.component.css']
})
export class MerchantCardComponent {
  @Input({ required: true })
  merchant!: UnitEntry<Merchant>;
}
