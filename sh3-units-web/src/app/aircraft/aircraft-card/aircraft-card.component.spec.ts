import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AircraftCardComponent } from './aircraft-card.component';

describe('AircraftCardComponent', () => {
  let component: AircraftCardComponent;
  let fixture: ComponentFixture<AircraftCardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AircraftCardComponent]
    });
    fixture = TestBed.createComponent(AircraftCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
