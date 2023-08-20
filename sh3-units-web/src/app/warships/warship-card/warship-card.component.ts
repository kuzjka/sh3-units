import { Component, Input } from '@angular/core';
import { UnitEntry, Warship } from "../../core/data.model";

@Component({
  selector: 'app-warship-card',
  templateUrl: './warship-card.component.html',
  styleUrls: ['./warship-card.component.css']
})
export class WarshipCardComponent {
  @Input({ required: true })
  warship!: UnitEntry<Warship>;


}
