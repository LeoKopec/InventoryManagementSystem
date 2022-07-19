import { Component, OnInit } from '@angular/core';
import { FruitApiService } from '../fruit-api.service';

@Component({
  selector: 'app-delete-warehouse',
  templateUrl: './delete-warehouse.component.html',
  styleUrls: ['./delete-warehouse.component.css']
})
export class DeleteWarehouseComponent implements OnInit {

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
    this.service.deleteWarehouse(this.deleteNum).subscribe(data => {
      console.log(data);
    });
  }
}
