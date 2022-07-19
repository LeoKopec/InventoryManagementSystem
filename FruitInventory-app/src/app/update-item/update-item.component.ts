import { Component, OnInit } from '@angular/core';
import { FruitApiService } from '../fruit-api.service';

@Component({
  selector: 'app-update-item',
  templateUrl: './update-item.component.html',
  styleUrls: ['./update-item.component.css']
})
export class UpdateItemComponent implements OnInit {

  service :FruitApiService;
  item :any = {};

  constructor(service :FruitApiService) { 
    this.service = service;
  }

  ngOnInit(): void {
  }

  submit(item :any) :void {
    this.service.updateItem(item).subscribe(resp => {
      console.log(resp);
    });
  }


}
