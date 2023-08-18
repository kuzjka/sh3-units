import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WarshipAddComponent } from './warship-add.component';

describe('WarshipAddComponent', () => {
  let component: WarshipAddComponent;
  let fixture: ComponentFixture<WarshipAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WarshipAddComponent]
    });
    fixture = TestBed.createComponent(WarshipAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
