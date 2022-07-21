import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject, tap } from 'rxjs';
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
refreshrequired = new Subject<void>;

get Refreshrequired() {
  return this.refreshrequired;
}

  constructor(http :HttpClient) {
    this.http = http;
  }

  updateItem(item :any) :Observable<any> {
    return this.http.put(environment.apiUrl + this.itemSubUrl, item).pipe(
      tap(()=>{
        this.Refreshrequired.next();
      })
    );
  }

  save(item :any) :Observable<any> {
    return this.http.post(environment.apiUrl + this.itemSubUrl, item).pipe(
      tap(()=>{
        this.Refreshrequired.next();
      })
    );
  }

  saveWarehouse(warehouse :any) :Observable<any> {
    return this.http.post(environment.apiUrl + this.warehouseSubUrl, warehouse).pipe(
      tap(()=>{
        this.Refreshrequired.next();
      })
    );
  }

  saveShipment(shipment :any) :Observable<any> {
    return this.http.post(environment.apiUrl + this.shipmentSubUrl, shipment).pipe(
      tap(()=>{
        this.Refreshrequired.next();
      })
    );
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
    return this.http.delete(environment.apiUrl + this.warehouseSubUrl + num).pipe(
      tap(()=>{
        this.Refreshrequired.next();
      })
    );
  }

  deleteShipment(num :number) :Observable<any> {
    return this.http.delete(environment.apiUrl + this.shipmentSubUrl + num).pipe(
      tap(()=>{
        this.Refreshrequired.next();
      })
    );
  }
}
