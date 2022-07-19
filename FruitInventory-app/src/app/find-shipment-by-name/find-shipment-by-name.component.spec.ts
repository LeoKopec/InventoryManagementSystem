import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindShipmentByNameComponent } from './find-shipment-by-name.component';

describe('FindShipmentByNameComponent', () => {
  let component: FindShipmentByNameComponent;
  let fixture: ComponentFixture<FindShipmentByNameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FindShipmentByNameComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FindShipmentByNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
