import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindShipmentsByWarehouseComponent } from './find-shipments-by-warehouse.component';

describe('FindShipmentsByWarehouseComponent', () => {
  let component: FindShipmentsByWarehouseComponent;
  let fixture: ComponentFixture<FindShipmentsByWarehouseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FindShipmentsByWarehouseComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FindShipmentsByWarehouseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
