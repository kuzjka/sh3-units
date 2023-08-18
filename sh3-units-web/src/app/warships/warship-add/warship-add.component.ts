import { Component } from '@angular/core';
import { WarshipCategory } from "../../shared/data.model";
import { FormBuilder, Validators } from "@angular/forms";
import { MatDialogRef } from "@angular/material/dialog";
import { UnitsService } from "../../shared/units.service";
import { MatSnackBar } from "@angular/material/snack-bar";

@Component({
  selector: 'app-warship-add',
  templateUrl: './warship-add.component.html',
  styleUrls: ['./warship-add.component.css']
})
export class WarshipAddComponent {
  CATEGORIES = Object.values(WarshipCategory);

  form = this.fb.nonNullable.group({
    name: ['', Validators.required],
    displacement: [0, Validators.required],
    length: [0, Validators.required],
    beam: [0, Validators.required],
    draft: [0, Validators.required],
    mast: [0, Validators.required],
    speed: [0, Validators.required],
    category: [WarshipCategory.Cruiser, Validators.required],
    deckGun: [true],
    aaGun: [false],
    torpedoes: [false],
    depthCharges: [false]
  });

  image?: ArrayBuffer;

  constructor(private fb: FormBuilder,
              private dialogRef: MatDialogRef<WarshipAddComponent>,
              private unitService: UnitsService,
              private snackBar: MatSnackBar) {}

  submit() {
    if (!this.image) return;
    this.unitService.addWarship(this.form.getRawValue(), this.image).subscribe({
      next: () => this.dialogRef.close(true),
      error: () => this.snackBar.open('Cannot add warship')
    });
  }

  cancel() {
    this.dialogRef.close(false);
  }

  imageLoaded(image: ArrayBuffer) {
    this.image = image;
  }
}
