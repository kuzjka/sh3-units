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
    ImagePasteComponent
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
    MatDialogModule,
    MatInputModule,
    MatSelectModule,
    MatSnackBarModule,
    MatTabsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
