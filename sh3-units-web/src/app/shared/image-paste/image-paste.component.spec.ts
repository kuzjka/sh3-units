import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImagePasteComponent } from './image-paste.component';

describe('ImagePasteComponent', () => {
  let component: ImagePasteComponent;
  let fixture: ComponentFixture<ImagePasteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ImagePasteComponent]
    });
    fixture = TestBed.createComponent(ImagePasteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
