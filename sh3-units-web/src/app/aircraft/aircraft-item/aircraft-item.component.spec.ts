import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AircraftItemComponent } from './aircraft-item.component';

describe('AircraftItemComponent', () => {
  let component: AircraftItemComponent;
  let fixture: ComponentFixture<AircraftItemComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AircraftItemComponent]
    });
    fixture = TestBed.createComponent(AircraftItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
