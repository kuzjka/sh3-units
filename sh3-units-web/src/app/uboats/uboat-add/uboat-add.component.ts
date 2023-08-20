import { Component } from '@angular/core';
import { FormBuilder, Validators } from "@angular/forms";
import { MatDialogRef } from "@angular/material/dialog";
import { UnitsService } from "../../core/units.service";
import { MatSnackBar } from "@angular/material/snack-bar";

@Component({
  selector: 'app-uboat-add',
  templateUrl: './uboat-add.component.html',
  styleUrls: ['./uboat-add.component.css']
})
export class UboatAddComponent {
  form = this.fb.nonNullable.group({
    name: ['', Validators.required],
    displacementSurfaced: [0, Validators.required],
    displacementSubmerged: [0, Validators.required],
    speedSurfaced: [0, Validators.required],
    speedSubmerged: [0, Validators.required],
    divingDepth: [0, Validators.required],
    bowTubes: [0, Validators.required],
    sternTubes: [0, Validators.required]
  });

  image?: ArrayBuffer;

  constructor(private fb: FormBuilder,
              private dialogRef: MatDialogRef<UboatAddComponent>,
              private unitService: UnitsService,
              private snackBar: MatSnackBar) {}

  submit() {
    if (!this.image) return;
    this.unitService.addUBoat(this.form.getRawValue(), this.image).subscribe({
      next: () => this.dialogRef.close(true),
      error: () => this.snackBar.open('Cannot add U-boat')
    });
  }

  cancel() {
    this.dialogRef.close(false);
  }

  imageLoaded(image: ArrayBuffer) {
    this.image = image;
  }
}
