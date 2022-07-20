import { Component, OnInit } from '@angular/core';
import { FruitApiService } from '../fruit-api.service';

@Component({
  selector: 'app-warehouse-list',
  templateUrl: './warehouse-list.component.html',
  styleUrls: ['./warehouse-list.component.css']
})
export class WarehouseListComponent implements OnInit {

  service :FruitApiService;
  warehouses :Array<any> = [];

  constructor(service :FruitApiService) { 
    this.service = service;
  }

  ngOnInit(): void {
    this.service.findAllWarehouses().subscribe(data => {
      this.warehouses = data;
    });
    this.service.Refreshrequired.subscribe(response => {
      this.service.findAllWarehouses().subscribe(data => {
        this.warehouses = data;
      });
    })
  }

}
