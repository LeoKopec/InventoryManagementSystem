import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FruitApiService {

http :HttpClient;
itemSubUrl :string = 'items/'
warehouseSubUrl :string = 'warehouses/'
shipmentSubUrl :string = 'shipments/'
allShipmentsSubUrl :string = 'allshipments/'
allWarehouseShipmentsSubUrl :string = 'warehouseshipments/'

  constructor(http :HttpClient) {
    this.http = http;
  }

  updateItem(item :any) :Observable<any> {
    return this.http.put(environment.apiUrl + this.itemSubUrl, item);
  }

  save(item :any) :Observable<any> {
    return this.http.post(environment.apiUrl + this.itemSubUrl, item);
  }

  saveWarehouse(warehouse :any) :Observable<any> {
    return this.http.post(environment.apiUrl + this.warehouseSubUrl, warehouse);
  }

  saveShipment(shipment :any) :Observable<any> {
    return this.http.post(environment.apiUrl + this.shipmentSubUrl, shipment);
  }

  findAll() :Observable<any> {
    return this.http.get(environment.apiUrl + this.itemSubUrl);
  }

  findAllWarehouses() :Observable<any> {
    return this.http.get(environment.apiUrl + this.warehouseSubUrl);
  }

  findAllShipments() :Observable<any> {
    return this.http.get(environment.apiUrl + this.allShipmentsSubUrl);
  }

  findAllWarehouseShipments(num :number) :Observable<any> {
    return this.http.get(environment.apiUrl + this.allWarehouseShipmentsSubUrl + num);
  }

  findByName(name :string) :Observable<any> {
    return this.http.get(environment.apiUrl + this.itemSubUrl + name);
  }

  findByNum(num :number) :Observable<any> {
    return this.http.get(environment.apiUrl + this.warehouseSubUrl + num);
  }

  findShipmentsByName(name :string) :Observable<any> {
    return this.http.get(environment.apiUrl + this.shipmentSubUrl + name);
  }

  findShipmentsByNum(num :number) :Observable<any>{
    return this.http.get(environment.apiUrl + this.shipmentSubUrl + num);
  }

  deleteWarehouse(num :number) :Observable<any> {
    return this.http.delete(environment.apiUrl + this.warehouseSubUrl + num);
  }

  deleteShipment(num :number) :Observable<any> {
    return this.http.delete(environment.apiUrl + this.shipmentSubUrl + num);
  }
}
