package com.skillstorm;

import java.util.List;

import com.skillstorm.doas.ItemDOA;
import com.skillstorm.doas.MySQLItemImpl;
import com.skillstorm.doas.MySQLShipmentDOAImpl;
import com.skillstorm.doas.MySQLWarehouseDOAImpl;
import com.skillstorm.doas.ShipmentDOA;
import com.skillstorm.doas.WarehouseDOA;
import com.skillstorm.models.Item;
import com.skillstorm.models.Shipment;
import com.skillstorm.models.Warehouse;

public class TestingDriver {

	public static void main(String[] args) {
		
		WarehouseDOA doa = new MySQLWarehouseDOAImpl();
		ItemDOA idoa = new MySQLItemImpl();
		ShipmentDOA sdoa = new MySQLShipmentDOAImpl();
		
		// sdoa.deleteByCrate(6);
		
		List<Shipment> shipments = sdoa.findAll();
		// List<Shipment> shipments = sdoa.findByItems("Apple");
		// List<Shipment> shipments = sdoa.findByWarehouse(2);
		System.out.println(shipments);
		
		// Shipment newShipment = new Shipment("Honeydew", 750, 2);
		// sdoa.save(newShipment);
		// System.out.println(newShipment);
		
		// System.out.println(sdoa.findByCrate(2));
		
		// List<Warehouse> warehouses = doa.findAll();
		// System.out.println(warehouses);
		// System.out.println(doa.findByNum(1));
		
		// Warehouse newWarehouse = new Warehouse(3, 50000, 0);
		// doa.save(newWarehouse);
		// System.out.println(doa.findByNum(3));
		
		// doa.deleteByNum(3);
		// List<Warehouse> warehouses2 = doa.findAll();
		// System.out.println(warehouses2);
		
		// Warehouse newCap = new Warehouse(2, 200000, 0);
		// doa.updateCurrentCapacity(newCap);
		// System.out.println(doa.findByNum(2));
		
		// Item newItem = new Item("Shrimp", 8.00);
		// idoa.save(newItem);
		// List<Item> items = idoa.findAll();
		// System.out.println(items);
		// System.out.println(idoa.findByName("Shrimp"));
		
		// Item newItem = new Item("Apple", 3.79);
		// idoa.updatePrice(newItem);
		// System.out.println(idoa.findByName("Apple"));
		
		
		
		
		
		
	}

}
