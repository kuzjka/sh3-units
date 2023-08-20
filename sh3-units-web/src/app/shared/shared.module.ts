import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ImagePasteComponent } from "./image-paste/image-paste.component";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from "@angular/material/input";



@NgModule({
  declarations: [
    ImagePasteComponent
  ],
  imports: [
    CommonModule,
    MatFormFieldModule,
    MatInputModule,
  ],
  exports: [
    ImagePasteComponent
  ]
})
export class SharedModule { }
