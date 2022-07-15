package com.skillstorm.models;

public class Warehouse {
	
	private int warehouseNum;
	private int maxCapacity;
	private int currentCapacity;
	
	public Warehouse() {
		
	}

	public Warehouse(int warehouseNum, int maxCapacity, int currentCapacity) {
		this.warehouseNum = warehouseNum;
		this.maxCapacity = maxCapacity;
		this.currentCapacity = currentCapacity;
	}

	public int getWarehouseNum() {
		return warehouseNum;
	}

	public void setWarehouseNum(int warehouseNum) {
		this.warehouseNum = warehouseNum;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public int getCurrentCapacity() {
		return currentCapacity;
	}

	public void setCurrentCapacity(int currentCapacity) {
		this.currentCapacity = currentCapacity;
	}

	@Override
	public String toString() {
		return "Warehouse [warehouseNum=" + warehouseNum + ", maxCapacity=" + maxCapacity + ", currentCapacity="
				+ currentCapacity + "]";
	}	
}
