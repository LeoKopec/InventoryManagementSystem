import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SaveWarehouseComponent } from './save-warehouse.component';

describe('SaveWarehouseComponent', () => {
  let component: SaveWarehouseComponent;
  let fixture: ComponentFixture<SaveWarehouseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SaveWarehouseComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SaveWarehouseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
