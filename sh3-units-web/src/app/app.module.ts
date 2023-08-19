import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { MerchantListComponent } from './merchants/merchant-list/merchant-list.component';
import { WarshipListComponent } from './warships/warship-list/warship-list.component';
import { UboatListComponent } from './uboats/uboat-list/uboat-list.component';
import { AircraftListComponent } from './aircraft/aircraft-list/aircraft-list.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTabsModule } from "@angular/material/tabs";
import { RouterModule, Routes } from "@angular/router";
import { MatButtonModule } from "@angular/material/button";
import { MerchantAddComponent } from './merchants/merchant-add/merchant-add.component';
import { MatDialogModule } from "@angular/material/dialog";
import { MatCardModule } from "@angular/material/card";
import { ReactiveFormsModule } from "@angular/forms";
import { MatInputModule } from "@angular/material/input";
import { MatSelectModule } from "@angular/material/select";
import { MatSnackBarModule } from "@angular/material/snack-bar";
import { ImagePasteComponent } from './shared/image-paste/image-paste.component';
import { editableGuard } from "./editable.guard";
import { HttpClientModule } from "@angular/common/http";
import { ImageViewComponent } from './shared/image-view/image-view.component';
import { MatIconModule } from "@angular/material/icon";
import { MerchantItemComponent } from './merchants/merchant-item/merchant-item.component';
import { WarshipAddComponent } from './warships/warship-add/warship-add.component';
import { WarshipItemComponent } from './warships/warship-item/warship-item.component';
import { MatCheckboxModule } from "@angular/material/checkbox";
import { WarshipCardComponent } from './warships/warship-card/warship-card.component';
import { MerchantCardComponent } from './merchants/merchant-card/merchant-card.component';
import { UboatCardComponent } from './uboats/uboat-card/uboat-card.component';
import { UboatItemComponent } from './uboats/uboat-item/uboat-item.component';
import { UboatAddComponent } from './uboats/uboat-add/uboat-add.component';
import { AircraftAddComponent } from './aircraft/aircraft-add/aircraft-add.component';
import { AircraftCardComponent } from './aircraft/aircraft-card/aircraft-card.component';
import { AircraftItemComponent } from './aircraft/aircraft-item/aircraft-item.component';

const routes: Routes = [
  { path: 'merchants', component: MerchantListComponent },
  { path: 'warships', component: WarshipListComponent },
  { path: 'uboats', component: UboatListComponent },
  { path: 'aircraft', component: AircraftListComponent },
  {
    path: 'nations',
    loadChildren: () => import('./nations/nations.module').then(m => m.NationsModule),
    canMatch: [editableGuard]
  },
  { path: '**', redirectTo: '/merchants' }
]

@NgModule({
  declarations: [
    AppComponent,
    MerchantListComponent,
    WarshipListComponent,
    UboatListComponent,
    AircraftListComponent,
    MerchantAddComponent,
    ImagePasteComponent,
    ImageViewComponent,
    MerchantItemComponent,
    WarshipAddComponent,
    WarshipItemComponent,
    WarshipCardComponent,
    MerchantCardComponent,
    UboatCardComponent,
    UboatItemComponent,
    UboatAddComponent,
    AircraftAddComponent,
    AircraftCardComponent,
    AircraftItemComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),

    /* Angular Material */
    MatButtonModule,
    MatCardModule,
    MatCheckboxModule,
    MatDialogModule,
    MatInputModule,
    MatSelectModule,
    MatSnackBarModule,
    MatTabsModule,
    MatIconModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
