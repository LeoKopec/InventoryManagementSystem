import { Component, OnInit } from '@angular/core';
import { FruitApiService } from '../fruit-api.service';

@Component({
  selector: 'app-save-item',
  templateUrl: './save-item.component.html',
  styleUrls: ['./save-item.component.css']
})
export class SaveItemComponent implements OnInit {

  service :FruitApiService;
  item :any = {};

  constructor(service :FruitApiService) { 
    this.service = service;
  }

  ngOnInit(): void {
  }

  submit(item :any) :void {
    this.service.save(item).subscribe(resp => {
      console.log(resp);
    });
  }

}
