import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PSEComponent } from './pse.component';

describe('PSEComponent', () => {
  let component: PSEComponent;
  let fixture: ComponentFixture<PSEComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PSEComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PSEComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
