import { Component, Input } from '@angular/core';
import { Aircraft, UnitEntry } from "../../core/data.model";

@Component({
  selector: 'app-aircraft-card',
  templateUrl: './aircraft-card.component.html',
  styleUrls: ['./aircraft-card.component.css']
})
export class AircraftCardComponent {
  @Input({ required: true })
  aircraft!: UnitEntry<Aircraft>;
}
