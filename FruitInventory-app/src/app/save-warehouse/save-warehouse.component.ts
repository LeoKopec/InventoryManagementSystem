import { Component, OnInit } from '@angular/core';
import { FruitApiService } from '../fruit-api.service';

@Component({
  selector: 'app-save-warehouse',
  templateUrl: './save-warehouse.component.html',
  styleUrls: ['./save-warehouse.component.css']
})
export class SaveWarehouseComponent implements OnInit {

  service :FruitApiService;
  warehouse :any = {};

  constructor(service :FruitApiService) { 
    this.service = service;
  }
  ngOnInit(): void {
  }

  submit(warehouse :any) :void {
    this.service.saveWarehouse(warehouse).subscribe(resp => {
      console.log(resp);
    });
  }

}
