import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SaveShipmentComponent } from './save-shipment.component';

describe('SaveShipmentComponent', () => {
  let component: SaveShipmentComponent;
  let fixture: ComponentFixture<SaveShipmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SaveShipmentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SaveShipmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
