package com.skillstorm.models;

public class Item {

	private String itemName;
	private double pricePerPound;
	
	public Item() {
		
	}

	public Item(String itemName, double pricePerPound) {
		super();
		this.itemName = itemName;
		this.pricePerPound = pricePerPound;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPricePerPound() {
		return pricePerPound;
	}

	public void setPricePerPound(double pricePerPound) {
		this.pricePerPound = pricePerPound;
	}

	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", pricePerPound=" + pricePerPound + "]";
	}
	
}
