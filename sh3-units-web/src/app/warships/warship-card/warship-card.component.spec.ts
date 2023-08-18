import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WarshipCardComponent } from './warship-card.component';

describe('WashipCardComponent', () => {
  let component: WarshipCardComponent;
  let fixture: ComponentFixture<WarshipCardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WarshipCardComponent]
    });
    fixture = TestBed.createComponent(WarshipCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
