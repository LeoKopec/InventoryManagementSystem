package com.skillstorm.doas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.conf.FruitInventoryDbCreds;
import com.skillstorm.models.Warehouse;

public class MySQLWarehouseDOAImpl implements WarehouseDOA{

	@Override
	public List<Warehouse> findAll() {
		String sql = "SELECT * FROM warehouses";
		try (Connection conn = FruitInventoryDbCreds.getInstance().getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			LinkedList<Warehouse> warehouses = new LinkedList<>();
			while (rs.next()) {
				Warehouse warehouse = new Warehouse(rs.getInt(1), rs.getInt(2), rs.getInt(3));
				warehouses.add(warehouse);
			}
			return warehouses;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Warehouse findByNum(int warehouseNum) {
		String sql = "SELECT * FROM warehouses WHERE warehouseNum = " + warehouseNum;
		try (Connection conn = FruitInventoryDbCreds.getInstance().getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return new Warehouse(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void save(Warehouse warehouse) {
		String sql = "INSERT INTO warehouses (warehouseNum, maxCapacity, currentCapacity) VALUES (?, ?, ?)";
		try (Connection conn = FruitInventoryDbCreds.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, warehouse.getWarehouseNum());
			ps.setInt(2, warehouse.getMaxCapacity());
			ps.setInt(3, warehouse.getCurrentCapacity());
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
	public void updateCurrentCapacity(Warehouse warehouse) {
		String sql = "UPDATE warehouses SET currentCapacity = ? WHERE warehouseNum = ?";
		try (Connection conn = FruitInventoryDbCreds.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, warehouse.getCurrentCapacity());
			ps.setInt(2, warehouse.getWarehouseNum());
			ps.executeUpdate(); 
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	

	@Override
	public void deleteByNum(int warehouseNum) {
		String sql = "DELETE FROM warehouses WHERE warehouseNum = " + warehouseNum;
		try (Connection conn = FruitInventoryDbCreds.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getMaxCap(int warehouseNum) {
		String sql = "SELECT maxCapacity FROM warehouses WHERE warehouseNum = " + warehouseNum;
		try (Connection conn = FruitInventoryDbCreds.getInstance().getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int getCurrentCap(int warehouseNum) {
		String sql = "SELECT currentCapacity FROM warehouses WHERE warehouseNum = " + warehouseNum;
		try (Connection conn = FruitInventoryDbCreds.getInstance().getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
