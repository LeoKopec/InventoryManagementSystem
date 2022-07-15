package com.skillstorm.doas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.conf.FruitInventoryDbCreds;
import com.skillstorm.models.Shipment;

public class MySQLShipmentDOAImpl implements ShipmentDOA{

	@Override
	public List<Shipment> findAll() {
		String sql = "SELECT * FROM shipment";
		try (Connection conn = FruitInventoryDbCreds.getInstance().getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			LinkedList<Shipment> shipments = new LinkedList<>();
			while (rs.next()) {
				Shipment shipment = new Shipment(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getInt(4));
				shipments.add(shipment);
			}
			return shipments;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Shipment findByCrate(int crateID) {
		String sql = "SELECT * FROM shipment WHERE crateID = " + crateID;
		try (Connection conn = FruitInventoryDbCreds.getInstance().getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return new Shipment(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getInt(4));
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Shipment> findByItems(String itemName) {
		String sql = "SELECT * FROM shipment WHERE itemName = ?";
		try (Connection conn = FruitInventoryDbCreds.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, itemName);
			ResultSet rs = ps.executeQuery();
			LinkedList<Shipment> shipments = new LinkedList<>();
			while (rs.next()) {
				Shipment shipment = new Shipment(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getInt(4));
				shipments.add(shipment);
			}
			return shipments;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Shipment> findByWarehouse(int warehouseNum) {
		String sql = "SELECT * FROM shipment WHERE warehouseNum = " + warehouseNum;
		try (Connection conn = FruitInventoryDbCreds.getInstance().getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			LinkedList<Shipment> shipments = new LinkedList<>();
			while (rs.next()) {
				Shipment shipment = new Shipment(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getInt(4));
				shipments.add(shipment);
			}
			return shipments;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void save(Shipment shipment) {
		String currentMaxId = "SELECT MAX(crateID) FROM shipment";
		try (Connection conn = FruitInventoryDbCreds.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(currentMaxId);
			if (rs.next()) {
				int result = rs.getInt(1);
				int maxId = result + 1;
				String sql = "INSERT INTO shipment (crateID, itemName, pounds, warehouseNum) VALUES (" + maxId + ", ?, ?, ?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, shipment.getItemName());
				ps.setInt(2, shipment.getPounds());
				ps.setInt(3, shipment.getWarehouseNum());
				int rowsAffected = ps.executeUpdate();
				if (rowsAffected != 0) {
					conn.commit();
				} else {
					conn.rollback();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteByCrate(int crateId) {
		String sql = "DELETE FROM shipment WHERE crateID = " + crateId;
		try (Connection conn = FruitInventoryDbCreds.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}