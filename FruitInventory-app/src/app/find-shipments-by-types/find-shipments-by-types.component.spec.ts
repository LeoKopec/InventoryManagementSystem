import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindShipmentsByTypesComponent } from './find-shipments-by-types.component';

describe('FindShipmentsByTypesComponent', () => {
  let component: FindShipmentsByTypesComponent;
  let fixture: ComponentFixture<FindShipmentsByTypesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FindShipmentsByTypesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FindShipmentsByTypesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
