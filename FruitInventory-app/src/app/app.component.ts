import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'FruitInventory-app';

  menuItems = [
    {linkId: 1, linkName: "Manage Shipments"}, 
    {linkId: 2, linkName: "Search Shipments"}, 
    {linkId: 3, linkName: "Manage Warehouses"}, 
    {linkId: 4, linkName: "Stored Fruit"}]
}
