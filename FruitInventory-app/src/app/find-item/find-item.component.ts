import { Component, OnInit } from '@angular/core';
import { FruitApiService } from '../fruit-api.service';

@Component({
  selector: 'app-find-item',
  templateUrl: './find-item.component.html',
  styleUrls: ['./find-item.component.css']
})
export class FindItemComponent implements OnInit {

  service :FruitApiService;
  searchName :string;
  item :any;

  constructor(service :FruitApiService) { 
    this.service = service;
    this.searchName = '';
  }
  ngOnInit(): void {
  }

  onChange(): void {
    this.service.findByName(this.searchName).subscribe(data => {
      this.item = data;
    });
  }

}
