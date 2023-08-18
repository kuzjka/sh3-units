import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UboatItemComponent } from './uboat-item.component';

describe('UboatItemComponent', () => {
  let component: UboatItemComponent;
  let fixture: ComponentFixture<UboatItemComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UboatItemComponent]
    });
    fixture = TestBed.createComponent(UboatItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
