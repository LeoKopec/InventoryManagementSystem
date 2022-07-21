import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DeleteShipmentComponent } from './delete-shipment/delete-shipment.component';
import { DeleteWarehouseComponent } from './delete-warehouse/delete-warehouse.component';
import { FindItemComponent } from './find-item/find-item.component';
import { FindShipmentByCrateComponent } from './find-shipment-by-crate/find-shipment-by-crate.component';
import { FindShipmentByNameComponent } from './find-shipment-by-name/find-shipment-by-name.component';
import { FindShipmentsByWarehouseComponent } from './find-shipments-by-warehouse/find-shipments-by-warehouse.component';
import { FindWarehouseComponent } from './find-warehouse/find-warehouse.component';
import { ItemListComponent } from './item-list/item-list.component';
import { SaveItemComponent } from './save-item/save-item.component';
import { SaveShipmentComponent } from './save-shipment/save-shipment.component';
import { SaveWarehouseComponent } from './save-warehouse/save-warehouse.component';
import { ShipmentListComponent } from './shipment-list/shipment-list.component';
import { UpdateItemComponent } from './update-item/update-item.component';
import { WarehouseListComponent } from './warehouse-list/warehouse-list.component';
import { ShipmentsComponent } from './shipments/shipments.component';
import { WarehouseComponent } from './warehouse/warehouse.component';
import { ItemsComponent } from './items/items.component';
import { FindShipmentsByTypesComponent } from './find-shipments-by-types/find-shipments-by-types.component';

const routes: Routes = [{
  path: 'item-list',
  component: ItemListComponent
}, {
  path: 'delete-shipment',
  component: DeleteShipmentComponent
}, {
  path: 'delete-warehouse',
  component: DeleteWarehouseComponent
}, {
  path: 'find-item',
  component: FindItemComponent
}, {
  path: 'find-shipment-by-crate',
  component: FindShipmentByCrateComponent
}, {
  path: 'find-shipment-by-name',
  component: FindShipmentByNameComponent
}, {
  path: 'find-shipments-by-warehouse',
  component: FindShipmentsByWarehouseComponent
}, {
  path: 'find-warehouse',
  component: FindWarehouseComponent
}, {
  path: 'save-item',
  component: SaveItemComponent
}, {
  path: 'save-shipment',
  component: SaveShipmentComponent
}, {
  path: 'save-warehouse',
  component: SaveWarehouseComponent
}, {
  path: 'shipment-list',
  component: ShipmentListComponent
}, {
  path: 'update-item',
  component: UpdateItemComponent
}, {
  path: 'warehouse-list',
  component: WarehouseListComponent
}, {
  path: 'shipments',
  component: ShipmentsComponent
}, {
  path: 'warehouses',
  component: WarehouseComponent
}, {
  path: 'items',
  component: ItemsComponent
}, {
  path: 'find-shipments-by-types',
  component: FindShipmentsByTypesComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
