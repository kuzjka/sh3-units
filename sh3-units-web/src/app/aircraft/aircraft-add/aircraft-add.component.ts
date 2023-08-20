import { Component } from '@angular/core';
import { FormBuilder, Validators } from "@angular/forms";
import { MatDialogRef } from "@angular/material/dialog";
import { UnitsService } from "../../core/units.service";
import { MatSnackBar } from "@angular/material/snack-bar";

@Component({
  selector: 'app-aircraft-add',
  templateUrl: './aircraft-add.component.html',
  styleUrls: ['./aircraft-add.component.css']
})
export class AircraftAddComponent {
  form = this.fb.nonNullable.group({
    name: ['', Validators.required],
    speed: [0, Validators.required],
    range: [0, Validators.required],
    length: [0, Validators.required],
    wingspan: [0, Validators.required],
    ordnance: [''],
    bombs: [true, Validators.required],
    depthCharges: [false, Validators.required],
    rockets: [false, Validators.required],
    torpedoes: [false, Validators.required],
    pakGun: [false, Validators.required],
    leighLight: [false, Validators.required],
    sirene: [false, Validators.required]
  });

  image?: ArrayBuffer;

  constructor(private fb: FormBuilder,
              private dialogRef: MatDialogRef<AircraftAddComponent>,
              private unitService: UnitsService,
              private snackBar: MatSnackBar) {}

  submit() {
    if (!this.image) return;
    this.unitService.addAircraft(this.form.getRawValue(), this.image).subscribe({
      next: () => this.dialogRef.close(true),
      error: () => this.snackBar.open('Cannot add aircraft')
    });
  }

  cancel() {
    this.dialogRef.close(false);
  }

  imageLoaded(image: ArrayBuffer) {
    this.image = image;
  }
}
