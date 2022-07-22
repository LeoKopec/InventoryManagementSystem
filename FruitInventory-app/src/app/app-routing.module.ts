import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ShipmentsComponent } from './shipments/shipments.component';
import { WarehouseComponent } from './warehouse/warehouse.component';
import { ItemsComponent } from './items/items.component';
import { FindShipmentsByTypesComponent } from './find-shipments-by-types/find-shipments-by-types.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [{
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
}, {
  path: 'home',
  component: HomeComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
