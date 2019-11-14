package com.kone.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kone.model.Elevator;
//jdbc connection
public class DataOfElevatorService {

	public List<Elevator> elevatorData(){
		//write logic to fetch the result set from database
		 Connection c = null;
	      Statement stmt = null;
	      List<Elevator> list=null;
	      Elevator elevator=new Elevator();
	      String ename;
	      int price;
	      int eid;
	      int stock;
	      String features;
	      try {
	    	 // System.out.println("Connection is going to be established");
	         //Class.forName("com.mysql.jdbc.Driver.");
	         c = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/koneiot",
	            "root", "krish@123");
	         c.setAutoCommit(false);
	         //System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM koneiot.koneelevators;" );
	         while ( rs.next() ) {
	            eid = rs.getInt("eid");
	            elevator.setEid(eid);
	            ename = rs.getString("ename");
	            elevator.setName(ename);
	            price  = rs.getInt("price");
	            elevator.setPrice(price);
	            stock = rs.getInt("stock");
	            elevator.setStock(stock);
	            features = rs.getString("features");
	            elevator.setFeatures(features);
	            System.out.println( "ID = " + eid );
	            System.out.println( "Type = " + ename );
	            System.out.println( "price = " + price );
	            System.out.println( "stock = " + stock );
	            System.out.println("features="+features);
	            System.out.println();
	         }
	         rs.close();
	         stmt.close();
	         c.close();
	         
	         list=new ArrayList<Elevator>();
	         list.add(elevator);
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Operation done successfully");
	      //List<Elevator> 
			//list.add("ID="+eid);
			;
			return list;
	   }
		
	}

