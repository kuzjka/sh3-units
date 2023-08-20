import { Component, Input } from '@angular/core';
import { UBoat, UnitEntry } from "../../core/data.model";

@Component({
  selector: 'app-uboat-card',
  templateUrl: './uboat-card.component.html',
  styleUrls: ['./uboat-card.component.css']
})
export class UboatCardComponent {
  @Input({ required: true })
  uboat!: UnitEntry<UBoat>;
}
