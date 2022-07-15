package com.skillstorm.doas;

import java.util.List;

import com.skillstorm.models.Item;

public interface ItemDOA {

	public List<Item> findAll();
	public Item findByName(String itemName);
	public void save(Item item);
	public void updatePrice(Item item);
}
