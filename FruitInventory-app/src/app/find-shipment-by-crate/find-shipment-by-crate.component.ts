import { Component, OnInit } from '@angular/core';
import { FruitApiService } from '../fruit-api.service';

@Component({
  selector: 'app-find-shipment-by-crate',
  templateUrl: './find-shipment-by-crate.component.html',
  styleUrls: ['./find-shipment-by-crate.component.css']
})
export class FindShipmentByCrateComponent implements OnInit {

  service :FruitApiService;
  searchNum :number;
  shipment :any;

  constructor(service :FruitApiService) { 
    this.service = service;
    this.searchNum = 0;
  }

  ngOnInit(): void {
  }

  onChange(): void {
    this.service.findShipmentsByNum(this.searchNum).subscribe(data => {
      this.shipment = data;
    });
  }

}
