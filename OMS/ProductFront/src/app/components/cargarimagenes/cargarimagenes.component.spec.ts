import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CargarimagenesComponent } from './cargarimagenes.component';

describe('CargarimagenesComponent', () => {
  let component: CargarimagenesComponent;
  let fixture: ComponentFixture<CargarimagenesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CargarimagenesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CargarimagenesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
