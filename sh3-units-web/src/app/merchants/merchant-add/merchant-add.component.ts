import { Component } from '@angular/core';
import { FormBuilder, Validators } from "@angular/forms";
import { MerchantCategory } from "../../shared/data.model";
import { MatDialogRef } from "@angular/material/dialog";
import { UnitsService } from "../../shared/units.service";
import { MatSnackBar } from "@angular/material/snack-bar";

@Component({
  selector: 'app-merchant-add',
  templateUrl: './merchant-add.component.html',
  styleUrls: ['./merchant-add.component.css']
})
export class MerchantAddComponent {
  CATEGORIES = Object.values(MerchantCategory);

  form = this.fb.nonNullable.group({
    name: ['', Validators.required],
    displacement: [0, Validators.required],
    length: [0, Validators.required],
    beam: [0, Validators.required],
    draft: [0, Validators.required],
    mast: [0, Validators.required],
    speed: [0, Validators.required],
    category: [MerchantCategory.Merchant, Validators.required]
  });

  image?: ArrayBuffer;

  constructor(private fb: FormBuilder,
              private dialogRef: MatDialogRef<MerchantAddComponent>,
              private unitsService: UnitsService,
              private snackBar: MatSnackBar) {
  }

  submit() {
    if (!this.image) return;
    this.unitsService.addMerchant(this.form.getRawValue(), this.image).subscribe({
      next: () => this.dialogRef.close(true),
      error: () => this.snackBar.open('Cannot add merchant')
    });
  }

  cancel() {
    this.dialogRef.close(false);
  }

  imageLoaded(image: ArrayBuffer) {
    this.image = image;
  }
}
