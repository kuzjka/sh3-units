import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NationOrderEntryComponent } from './nation-order-entry.component';

describe('NationOrderEntryComponent', () => {
  let component: NationOrderEntryComponent;
  let fixture: ComponentFixture<NationOrderEntryComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NationOrderEntryComponent]
    });
    fixture = TestBed.createComponent(NationOrderEntryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
