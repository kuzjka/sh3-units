import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NationAddComponent } from './nation-add.component';

describe('NationAddComponent', () => {
  let component: NationAddComponent;
  let fixture: ComponentFixture<NationAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NationAddComponent]
    });
    fixture = TestBed.createComponent(NationAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
