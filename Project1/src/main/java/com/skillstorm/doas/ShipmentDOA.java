package com.skillstorm.doas;

import java.util.List;

import com.skillstorm.models.Shipment;

public interface ShipmentDOA {
	
	public List<Shipment> findAll();
	public Shipment findByCrate(int crateID);
	public List<Shipment> findByItems(String itemName);
	public List<Shipment> findByWarehouse(int warehouseNum);
	public void save(Shipment shipment);
	public void deleteByCrate(int crateId);
	
	
}
