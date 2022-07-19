import { Component, OnInit } from '@angular/core';
import { FruitApiService } from '../fruit-api.service';

@Component({
  selector: 'app-delete-shipment',
  templateUrl: './delete-shipment.component.html',
  styleUrls: ['./delete-shipment.component.css']
})
export class DeleteShipmentComponent implements OnInit {

  service :FruitApiService;
  deleteNum :number;
  warehouse :any;

  constructor(service :FruitApiService) { 
    this.service = service;
    this.deleteNum = 0;
  }

  ngOnInit(): void {
  }

  onChange(): void {
    this.service.deleteShipment(this.deleteNum).subscribe(data => {
      console.log(data);
    });
  }

}
