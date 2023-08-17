import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NationsComponent } from './nations/nations.component';
import { NationOrdersComponent } from "./nation-orders/nation-orders.component";
import { MatButtonModule } from "@angular/material/button";

@NgModule({
  declarations: [
    NationsComponent,
    NationOrdersComponent
  ],
  imports: [
    CommonModule,

    /* Angular Material */
    MatButtonModule,
  ]
})
export class NationsModule { }
