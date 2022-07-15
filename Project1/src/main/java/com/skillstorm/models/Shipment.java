package com.skillstorm.models;

public class Shipment {
	
	private int crateID;
	private String itemName;
	private int pounds;
	private int warehouseNum;
	
	public Shipment() {

	}

	public Shipment(String itemName, int pounds, int warehouseNum) {
		this.itemName = itemName;
		this.pounds = pounds;
		this.warehouseNum = warehouseNum;
	}

	public Shipment(int crateID, String itemName, int pounds, int warehouseNum) {
		this.crateID = crateID;
		this.itemName = itemName;
		this.pounds = pounds;
		this.warehouseNum = warehouseNum;
	}

	public int getCrateID() {
		return crateID;
	}

	public void setCrateID(int crateID) {
		this.crateID = crateID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPounds() {
		return pounds;
	}

	public void setPounds(int pounds) {
		this.pounds = pounds;
	}

	public int getWarehouseNum() {
		return warehouseNum;
	}

	public void setWarehouseNum(int warehouseNum) {
		this.warehouseNum = warehouseNum;
	}

	@Override
	public String toString() {
		return "Shipment [crateID=" + crateID + ", itemName=" + itemName + ", pounds=" + pounds + ", warehouseNum="
				+ warehouseNum + "]";
	}
}
