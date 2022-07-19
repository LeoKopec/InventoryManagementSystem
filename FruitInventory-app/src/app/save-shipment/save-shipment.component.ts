import { Component, OnInit } from '@angular/core';
import { FruitApiService } from '../fruit-api.service';

@Component({
  selector: 'app-save-shipment',
  templateUrl: './save-shipment.component.html',
  styleUrls: ['./save-shipment.component.css']
})
export class SaveShipmentComponent implements OnInit {
  
  service :FruitApiService;
  shipment :any = {};

  constructor(service :FruitApiService) { 
    this.service = service;
  }
  ngOnInit(): void {
  }

  submit(shipment :any) :void {
    this.service.saveShipment(shipment).subscribe(resp => {
      console.log(resp);
    });
  }
}
