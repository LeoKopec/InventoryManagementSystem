import { Component, OnInit } from '@angular/core';
import { FruitApiService } from '../fruit-api.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {

  service :FruitApiService;
  items :Array<any> = [];

  constructor(service :FruitApiService) { 
    this.service = service;
  }

  ngOnInit(): void {
    this.service.findAll().subscribe(data => {
      this.items = data;
    });
    this.service.Refreshrequired.subscribe(response => {
      this.service.findAll().subscribe(data => {
        this.items = data;
      })
    });
  }
}
