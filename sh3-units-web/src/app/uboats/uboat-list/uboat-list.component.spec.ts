import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UboatListComponent } from './uboat-list.component';

describe('UboatListComponent', () => {
  let component: UboatListComponent;
  let fixture: ComponentFixture<UboatListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UboatListComponent]
    });
    fixture = TestBed.createComponent(UboatListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
