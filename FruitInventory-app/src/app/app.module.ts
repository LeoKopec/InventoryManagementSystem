import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ItemListComponent } from './item-list/item-list.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { FindItemComponent } from './find-item/find-item.component';
import { SaveItemComponent } from './save-item/save-item.component';
import { WarehouseListComponent } from './warehouse-list/warehouse-list.component';
import { FindWarehouseComponent } from './find-warehouse/find-warehouse.component';
import { SaveWarehouseComponent } from './save-warehouse/save-warehouse.component';
import { UpdateItemComponent } from './update-item/update-item.component';
import { DeleteWarehouseComponent } from './delete-warehouse/delete-warehouse.component';
import { ShipmentListComponent } from './shipment-list/shipment-list.component';
import { FindShipmentByNameComponent } from './find-shipment-by-name/find-shipment-by-name.component';
import { FindShipmentByCrateComponent } from './find-shipment-by-crate/find-shipment-by-crate.component';
import { SaveShipmentComponent } from './save-shipment/save-shipment.component';
import { DeleteShipmentComponent } from './delete-shipment/delete-shipment.component';
import { FindShipmentsByWarehouseComponent } from './find-shipments-by-warehouse/find-shipments-by-warehouse.component';

@NgModule({
  declarations: [
    AppComponent,
    ItemListComponent,
    FindItemComponent,
    SaveItemComponent,
    WarehouseListComponent,
    FindWarehouseComponent,
    SaveWarehouseComponent,
    UpdateItemComponent,
    DeleteWarehouseComponent,
    ShipmentListComponent,
    FindShipmentByNameComponent,
    FindShipmentByCrateComponent,
    SaveShipmentComponent,
    DeleteShipmentComponent,
    FindShipmentsByWarehouseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule, 
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
