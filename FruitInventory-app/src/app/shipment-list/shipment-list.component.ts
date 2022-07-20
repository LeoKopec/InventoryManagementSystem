import { Component, OnInit } from '@angular/core';
import { FruitApiService } from '../fruit-api.service';

@Component({
  selector: 'app-shipment-list',
  templateUrl: './shipment-list.component.html',
  styleUrls: ['./shipment-list.component.css']
})
export class ShipmentListComponent implements OnInit {

  service :FruitApiService;
  shipments :Array<any> = [];

  constructor(service :FruitApiService) { 
    this.service = service;
  }

  ngOnInit(): void {
    this.service.findAllShipments().subscribe(data => {
      this.shipments = data;
    });
    this.service.Refreshrequired.subscribe(response => {
      this.service.findAllShipments().subscribe(data => {
        this.shipments = data;
      });
    })
  }

}
