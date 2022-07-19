import { Component, OnInit } from '@angular/core';
import { FruitApiService } from '../fruit-api.service';

@Component({
  selector: 'app-find-shipment-by-name',
  templateUrl: './find-shipment-by-name.component.html',
  styleUrls: ['./find-shipment-by-name.component.css']
})
export class FindShipmentByNameComponent implements OnInit {

  service :FruitApiService;
  searchName :string;
  shipments :Array<any> = []

  constructor(service :FruitApiService) { 
    this.service = service;
    this.searchName = '';
  }

  ngOnInit(): void {
  }

  onChange(): void {
    this.service.findShipmentsByName(this.searchName).subscribe(data => {
      this.shipments = data;
    });
  }

}
