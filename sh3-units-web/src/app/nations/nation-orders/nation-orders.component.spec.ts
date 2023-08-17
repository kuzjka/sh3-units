import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NationOrdersComponent } from './nation-orders.component';

describe('NationOrdersComponent', () => {
  let component: NationOrdersComponent;
  let fixture: ComponentFixture<NationOrdersComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NationOrdersComponent]
    });
    fixture = TestBed.createComponent(NationOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
