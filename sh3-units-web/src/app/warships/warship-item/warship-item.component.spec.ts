import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WarshipItemComponent } from './warship-item.component';

describe('WarshipItemComponent', () => {
  let component: WarshipItemComponent;
  let fixture: ComponentFixture<WarshipItemComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WarshipItemComponent]
    });
    fixture = TestBed.createComponent(WarshipItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
