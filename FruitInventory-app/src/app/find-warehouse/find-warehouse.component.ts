import { Component, OnInit } from '@angular/core';
import { FruitApiService } from '../fruit-api.service';

@Component({
  selector: 'app-find-warehouse',
  templateUrl: './find-warehouse.component.html',
  styleUrls: ['./find-warehouse.component.css']
})
export class FindWarehouseComponent implements OnInit {

  service :FruitApiService;
  searchNum :number;
  warehouse :any;

  constructor(service :FruitApiService) { 
    this.service = service;
    this.searchNum = 0;
  }
  ngOnInit(): void {
  }

  onChange(): void {
    this.service.findByNum(this.searchNum).subscribe(data => {
      this.warehouse = data;
    });
  }

}
