package com.skillstorm.doas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.conf.FruitInventoryDbCreds;
import com.skillstorm.models.Item;

public class MySQLItemImpl implements ItemDOA{

	@Override
	public List<Item> findAll() {
		String sql = "SELECT * FROM items";
		try (Connection conn = FruitInventoryDbCreds.getInstance().getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			LinkedList<Item> items = new LinkedList<>();
			while (rs.next()) {
				Item item = new Item(rs.getString(1), rs.getDouble(2));
				items.add(item);
			}
			return items;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Item findByName(String itemName) {
		String sql = "SELECT * FROM items WHERE itemName = ?";
		try (Connection conn = FruitInventoryDbCreds.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, itemName);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Item(rs.getString(1), rs.getDouble(2));
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public void save(Item item) {
		String sql = "INSERT INTO items (itemName, pricePerPound) VALUES (?, ?)";
		try (Connection conn = FruitInventoryDbCreds.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, item.getItemName());
			ps.setDouble(2, item.getPricePerPound());
			int rowsAffected = ps.executeUpdate();
			if (rowsAffected != 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updatePrice(Item item) {
		String sql = "UPDATE items SET pricePerPound = ? WHERE itemName = ?";
		try (Connection conn = FruitInventoryDbCreds.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, item.getPricePerPound());
			ps.setString(2, item.getItemName());
			ps.executeUpdate(); 
			conn.commit();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
