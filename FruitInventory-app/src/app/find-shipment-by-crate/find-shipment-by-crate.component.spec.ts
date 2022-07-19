import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindShipmentByCrateComponent } from './find-shipment-by-crate.component';

describe('FindShipmentByCrateComponent', () => {
  let component: FindShipmentByCrateComponent;
  let fixture: ComponentFixture<FindShipmentByCrateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FindShipmentByCrateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FindShipmentByCrateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
