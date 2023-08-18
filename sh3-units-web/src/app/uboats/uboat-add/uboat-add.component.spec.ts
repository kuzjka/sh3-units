import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UboatAddComponent } from './uboat-add.component';

describe('UboatAddComponent', () => {
  let component: UboatAddComponent;
  let fixture: ComponentFixture<UboatAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UboatAddComponent]
    });
    fixture = TestBed.createComponent(UboatAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
