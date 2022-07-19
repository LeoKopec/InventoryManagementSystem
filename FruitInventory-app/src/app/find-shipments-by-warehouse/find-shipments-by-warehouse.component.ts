import { Component, OnInit } from '@angular/core';
import { FruitApiService } from '../fruit-api.service';

@Component({
  selector: 'app-find-shipments-by-warehouse',
  templateUrl: './find-shipments-by-warehouse.component.html',
  styleUrls: ['./find-shipments-by-warehouse.component.css']
})
export class FindShipmentsByWarehouseComponent implements OnInit {

  service :FruitApiService;
  searchNum :number;
  shipments :Array<any> = []

  constructor(service :FruitApiService) { 
    this.service = service;
    this.searchNum= 0;
  }

  ngOnInit(): void {
  }

  onChange(): void {
    this.service.findAllWarehouseShipments(this.searchNum).subscribe(data => {
      this.shipments = data;
    });
  }

}
