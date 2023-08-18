import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UboatCardComponent } from './uboat-card.component';

describe('UboatCardComponent', () => {
  let component: UboatCardComponent;
  let fixture: ComponentFixture<UboatCardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UboatCardComponent]
    });
    fixture = TestBed.createComponent(UboatCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
