import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MerchantItemComponent } from './merchant-item.component';

describe('MerchantItemComponent', () => {
  let component: MerchantItemComponent;
  let fixture: ComponentFixture<MerchantItemComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MerchantItemComponent]
    });
    fixture = TestBed.createComponent(MerchantItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
