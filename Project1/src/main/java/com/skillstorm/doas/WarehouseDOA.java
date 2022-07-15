package com.skillstorm.doas;

import java.util.List;

import com.skillstorm.models.Warehouse;

public interface WarehouseDOA {

	public List<Warehouse> findAll();
	public Warehouse findByNum(int warehouseNum);
	public void save(Warehouse warehouse);
	public void updateCurrentCapacity(Warehouse warehouse);
	public void deleteByNum(int warehouseNum);
}
