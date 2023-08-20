import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NationOrderSelectorComponent } from './nation-order-selector.component';

describe('NationOrderSelectorComponent', () => {
  let component: NationOrderSelectorComponent;
  let fixture: ComponentFixture<NationOrderSelectorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NationOrderSelectorComponent]
    });
    fixture = TestBed.createComponent(NationOrderSelectorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
