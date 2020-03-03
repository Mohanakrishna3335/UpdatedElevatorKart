package com.kone.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.io.*;
import com.kone.console.Console;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import com.kone.dao.ElevatorDao;
import com.kone.model.Elevator;

//All the Database operations Implementation is provided in ElevatorDaoImpl class 
public class ElevatorDaoImpl implements ElevatorDao {
	Console logger = new Console();
	Session session = null;
	Transaction tx = null;
	Properties prop = null;

//configuration logic 
	private void getConnectionLogic() throws Exception {
		Configuration con = new Configuration().configure().addAnnotatedClass(Elevator.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		session = sf.openSession();
		tx = session.beginTransaction();
		InputStream input = ElevatorDaoImpl.class.getClassLoader().getResourceAsStream("/config.properties");
		{
			prop = new Properties();
			// load a properties file from class path, inside static method
			prop.load(input);
		}
	}

//used to fetch the allElevators data from DB
	public List<Elevator> elevatorData() throws Exception {
		List<Elevator> list = null;
		getConnectionLogic();
		String sql = prop.getProperty("allElevators");

		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Elevator.class);
		query.list();
		list = new ArrayList<Elevator>();
		for (Object o : query.list()) {
			list.add((Elevator) o);
		}
		tx.commit();
		return list;
	}
	// used to fetch the connectedElevatorsData from DB

	public List<Elevator> ConnectedelevatorData() throws Exception {
		List<Elevator> list = null;
		getConnectionLogic();

		String sql = prop.getProperty("connectedElevators");
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Elevator.class);
		query.list();
		list = new ArrayList<Elevator>();
		for (Object o : query.list()) {
			list.add((Elevator) o);
		}
		tx.commit();
		return list;
	}

//used to fetch the nonConnectedElevators data from DB
	public List<Elevator> NonConnectedelevatorData() throws Exception {
		List<Elevator> list = null;
		getConnectionLogic();

		String sql = prop.getProperty("nonConnectedElevators");

		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Elevator.class);
		query.list();
		list = new ArrayList<Elevator>();
		for (Object o : query.list()) {
			list.add((Elevator) o);
		}
		tx.commit();
		return list;

	}

//used to fetch the DxelevatorData from DB
	public List<Elevator> DXelevatorData() throws Exception {
		List<Elevator> list = null;
		getConnectionLogic();

		String sql = prop.getProperty("digitalElevators");

		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Elevator.class);
		query.list();
		list = new ArrayList<Elevator>();
		for (Object o : query.list()) {
			list.add((Elevator) o);
		}
		tx.commit();
		return list;
	}

//add the elevator data to the DB
	public void addElevator(Elevator elevator) throws Exception {
		int equipementNumber = elevator.getEno();
		String elevatorName = elevator.getEname();
		String elevatorType = elevator.getEtype();
		String elevatorFeatures = elevator.getFeatures();
		int elevatorPrice = elevator.getPrice();
		int elevatorStock = elevator.getStock();

		elevator.setEno(equipementNumber);
		elevator.setEname(elevatorName);
		elevator.setEtype(elevatorType);
		elevator.setFeatures(elevatorFeatures);
		elevator.setPrice(elevatorPrice);
		elevator.setStock(elevatorStock);

		getConnectionLogic();

		session.save(elevator);
		tx.commit();

	}

}

//JDBC DAO layer

/*
 * import java.sql.Connection; import java.sql.DriverManager; import
 * java.sql.PreparedStatement; import java.sql.Statement;
 */

/*
 * 
 * public List<Elevator> elevatorData() throws Exception {
 * 
 * List<Elevator> list = null; ResultSet rs = null;Statement stmt = null;
 * 
 * try { getConnection(); rs =
 * stmt.executeQuery("SELECT * FROM koneiot.allelevators;");
 * System.out.println("result set==" + rs); list = new ArrayList<Elevator>();
 * while (rs.next()) { Elevator elevator = new Elevator();
 * elevator.setEno(rs.getInt("eno")); elevator.setName(rs.getString("ename"));
 * elevator.setPrice(rs.getInt("price")); elevator.setStock(rs.getInt("stock"));
 * elevator.setFeatures(rs.getString("features"));
 * elevator.setEtype(rs.getString("etype")); list.add(elevator); } } catch
 * (Exception e) { System.err.println(e.getClass().getName() + "=And then= " +
 * e.getMessage()); } finally { if (rs != null) { rs.close(); stmt.close(); } }
 * System.out.println("Operation done successfully"); return list; }
 */

/*
 * private void getConnection() throws Exception { Connection c = null;
 * Class.forName("com.mysql.jdbc.Driver"); c =
 * DriverManager.getConnection("jdbc:mysql://localhost:3306/koneiot", "root",
 * "root"); c.setAutoCommit(false);
 * 
 * stmt = c.createStatement(); }
 */

/*
 * List<Elevator> list = null; ResultSet rs = null;
 * 
 * try { getConnection(); rs = stmt.
 * executeQuery("SELECT * FROM koneiot.allelevators where etype='connected';");
 * System.out.println("result set==" + rs); list = new ArrayList<Elevator>();
 * while (rs.next()) { Elevator elevator = new Elevator();
 * elevator.setEno(rs.getInt("eno")); elevator.setName(rs.getString("ename"));
 * elevator.setPrice(rs.getInt("price")); elevator.setStock(rs.getInt("stock"));
 * elevator.setFeatures(rs.getString("features")); list.add(elevator); } } catch
 * (Exception e) { System.err.println(e.getClass().getName() + "=And then= " +
 * e.getMessage()); } finally { if (rs != null) { rs.close(); stmt.close(); } }
 * System.out.println("Operation done successfully"); return list;
 */
/*
 * List<Elevator> list = null; ResultSet rs = null;
 * 
 * try { getConnection(); rs = stmt.
 * executeQuery("SELECT * FROM koneiot.allelevators where etype='Non-Connected';"
 * ); System.out.println("result set==" + rs); list = new ArrayList<Elevator>();
 * while (rs.next()) { Elevator elevator = new Elevator();
 * elevator.setEno(rs.getInt("eno")); elevator.setName(rs.getString("ename"));
 * elevator.setPrice(rs.getInt("price")); elevator.setStock(rs.getInt("stock"));
 * elevator.setFeatures(rs.getString("features")); list.add(elevator);
 * 
 * } } catch (Exception e) { System.err.println(e.getClass().getName() +
 * "=And then= " + e.getMessage()); } finally { if (rs != null) { rs.close();
 * stmt.close(); } } System.out.println("Operation done successfully"); return
 * list;
 */
/*
 * List<Elevator> list = null; ResultSet rs = null;
 * 
 * try { getConnection(); rs =
 * stmt.executeQuery("SELECT * FROM koneiot.allelevators where etype='DX';");
 * System.out.println("result set==" + rs); list = new ArrayList<Elevator>();
 * while (rs.next()) { Elevator elevator = new Elevator();
 * elevator.setEno(rs.getInt("eno")); elevator.setName(rs.getString("ename"));
 * elevator.setPrice(rs.getInt("price")); elevator.setStock(rs.getInt("stock"));
 * elevator.setFeatures(rs.getString("features")); list.add(elevator); } } catch
 * (Exception e) { System.err.println(e.getClass().getName() + "=And then= " +
 * e.getMessage()); } finally { if (rs != null) { rs.close(); stmt.close(); } }
 * System.out.println("Operation done successfully"); return list;
 */
/*
 * try { Class.forName("com.mysql.jdbc.Driver");
 * 
 * Connection c =
 * DriverManager.getConnection("jdbc:mysql://localhost:3306/koneiot", "root",
 * "root"); int equipementNumber = elevator.getEno(); String elevatorName =
 * elevator.getName(); String elevatorType = elevator.getEtype(); String
 * elevatorFeatures = elevator.getFeatures(); int elevatorPrice =
 * elevator.getPrice(); int elevatorStock = elevator.getStock();
 * 
 * PreparedStatement stmt = c.prepareStatement(
 * "insert into koneiot.allelevators (eno,ename,price,stock,features,etype) values(?,?,?,?,?,?)"
 * ); stmt.setInt(1, equipementNumber); stmt.setString(2, elevatorName);
 * stmt.setInt(3, elevatorPrice); stmt.setInt(4, elevatorStock);
 * stmt.setString(5, elevatorFeatures); stmt.setString(6, elevatorType);
 * 
 * int i = stmt.executeUpdate(); System.out.println(i + " records inserted");
 * 
 * } catch (Exception e) { System.err.println(e.getClass().getName() +
 * "=and then=" + e.getMessage()); } finally { if (stmt != null) {
 * 
 * stmt.close(); } } System.out.println("Successfully inserted into table");
 * 
 * }
 */
//properties
