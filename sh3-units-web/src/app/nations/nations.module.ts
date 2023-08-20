import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NationsComponent } from './nations/nations.component';
import { NationOrdersComponent } from "./nation-orders/nation-orders.component";
import { MatButtonModule } from "@angular/material/button";
import { MatSidenavModule } from "@angular/material/sidenav";
import { NationAddComponent } from './nation-add/nation-add.component';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatSelectModule } from "@angular/material/select";
import { MatSliderModule } from "@angular/material/slider";
import { MatDialogModule } from "@angular/material/dialog";
import { MatSnackBarModule } from "@angular/material/snack-bar";
import { NationsService } from "./nations.service";
import { MatInputModule } from "@angular/material/input";
import { MatListModule } from "@angular/material/list";
import { RouterModule, Routes } from "@angular/router";
import { SharedModule } from "../shared/shared.module";
import { NationOrderEntryComponent } from './nation-orders/nation-order-entry/nation-order-entry.component';
import { NationOrderSelectorComponent } from './nation-orders/nation-order-selector/nation-order-selector.component';

const routes: Routes = [
  { path: '**', component: NationsComponent }
]

@NgModule({
  declarations: [
    NationsComponent,
    NationOrdersComponent,
    NationAddComponent,
    NationOrderEntryComponent,
    NationOrderSelectorComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forChild(routes),

    SharedModule,

    /* Angular Material */
    MatButtonModule,
    MatDialogModule,
    MatFormFieldModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSnackBarModule,
    MatInputModule,
    MatListModule
  ],
  providers: [
    { provide: NationsService, useClass: NationsService }
  ]
})
export class NationsModule { }
