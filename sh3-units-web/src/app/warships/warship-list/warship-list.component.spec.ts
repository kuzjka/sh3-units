import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WarshipListComponent } from './warship-list.component';

describe('WarshipListComponent', () => {
  let component: WarshipListComponent;
  let fixture: ComponentFixture<WarshipListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WarshipListComponent]
    });
    fixture = TestBed.createComponent(WarshipListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
