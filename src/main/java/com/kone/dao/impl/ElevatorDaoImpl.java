package com.kone.dao.impl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kone.dao.ElevatorDao;
import com.kone.model.Elevator;

public class ElevatorDaoImpl implements ElevatorDao {
	Statement stmt = null;

	public List<Elevator> elevatorData() throws Exception {

		List<Elevator> list = null;
		ResultSet rs = null;

		try {
			getConnection();
			rs = stmt.executeQuery("SELECT * FROM koneiot.allelevators;");
			System.out.println("result set==" + rs);
			list = new ArrayList<Elevator>();
			while (rs.next()) {
				Elevator elevator = new Elevator();
				elevator.setEno(rs.getInt("eno"));
				elevator.setName(rs.getString("ename"));
				elevator.setPrice(rs.getInt("price"));
				elevator.setStock(rs.getInt("stock"));
				elevator.setFeatures(rs.getString("features"));
				elevator.setEtype(rs.getString("etype"));
				list.add(elevator);
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + "=And then= " + e.getMessage());
		} finally {
			if (rs != null) {
				rs.close();
				stmt.close();
			}
		}
		System.out.println("Operation done successfully");
		return list;
	}

	private void getConnection() throws Exception {
		Connection c = null;
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/koneiot", "root", "root");
		c.setAutoCommit(false);

		stmt = c.createStatement();
	}

	public List<Elevator> ConnectedelevatorData() throws Exception {
		List<Elevator> list = null;
		ResultSet rs = null;

		try {
			getConnection();
			rs = stmt.executeQuery("SELECT * FROM koneiot.allelevators where etype='connected';");
			System.out.println("result set==" + rs);
			list = new ArrayList<Elevator>();
			while (rs.next()) {
				Elevator elevator = new Elevator();
				elevator.setEno(rs.getInt("eno"));
				elevator.setName(rs.getString("ename"));
				elevator.setPrice(rs.getInt("price"));
				elevator.setStock(rs.getInt("stock"));
				elevator.setFeatures(rs.getString("features"));
				list.add(elevator);
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + "=And then= " + e.getMessage());
		} finally {
			if (rs != null) {
				rs.close();
				stmt.close();
			}
		}
		System.out.println("Operation done successfully");
		return list;
	}

	public List<Elevator> NonConnectedelevatorData() throws Exception {
		List<Elevator> list = null;
		ResultSet rs = null;

		try {
			getConnection();
			rs = stmt.executeQuery("SELECT * FROM koneiot.allelevators where etype='Non-Connected';");
			System.out.println("result set==" + rs);
			list = new ArrayList<Elevator>();
			while (rs.next()) {
				Elevator elevator = new Elevator();
				elevator.setEno(rs.getInt("eno"));
				elevator.setName(rs.getString("ename"));
				elevator.setPrice(rs.getInt("price"));
				elevator.setStock(rs.getInt("stock"));
				elevator.setFeatures(rs.getString("features"));
				list.add(elevator);
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + "=And then= " + e.getMessage());
		} finally {
			if (rs != null) {
				rs.close();
				stmt.close();
			}
		}
		System.out.println("Operation done successfully");
		return list;
	}

	public List<Elevator> DXelevatorData() throws Exception {
		List<Elevator> list = null;
		ResultSet rs = null;

		try {
			getConnection();
			rs = stmt.executeQuery("SELECT * FROM koneiot.allelevators where etype='DX';");
			System.out.println("result set==" + rs);
			list = new ArrayList<Elevator>();
			while (rs.next()) {
				Elevator elevator = new Elevator();
				elevator.setEno(rs.getInt("eno"));
				elevator.setName(rs.getString("ename"));
				elevator.setPrice(rs.getInt("price"));
				elevator.setStock(rs.getInt("stock"));
				elevator.setFeatures(rs.getString("features"));
				list.add(elevator);
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + "=And then= " + e.getMessage());
		} finally {
			if (rs != null) {
				rs.close();
				stmt.close();
			}
		}
		System.out.println("Operation done successfully");
		return list;
	}

	public void addElevator(Elevator elevator) throws Exception {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/koneiot", "root", "root");
			int equipementNumber = elevator.getEno();
			String elevatorName = elevator.getName();
			String elevatorType = elevator.getEtype();
			String elevatorFeatures = elevator.getFeatures();
			int elevatorPrice = elevator.getPrice();
			int elevatorStock = elevator.getStock();

			PreparedStatement stmt = c.prepareStatement(
					"insert into koneiot.allelevators (eno,ename,price,stock,features,etype) values(?,?,?,?,?,?)");
			stmt.setInt(1, equipementNumber);
			stmt.setString(2, elevatorName);
			stmt.setInt(3, elevatorPrice);
			stmt.setInt(4, elevatorStock);
			stmt.setString(5, elevatorFeatures);
			stmt.setString(6, elevatorType);

			int i = stmt.executeUpdate();
			System.out.println(i + " records inserted");

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + "=and then=" + e.getMessage());
		} finally {
			if(stmt!=null) {

			stmt.close();
			}
		}
		System.out.println("Successfully inserted into table");

	}

}
