package com.kone.View;

import java.util.List;
import java.util.Scanner;
import com.kone.Implementation.Cart;
import com.kone.console.Console;
import com.kone.dao.impl.ElevatorDaoImpl;
import com.kone.model.Elevator;

/*
 * UI class contains the methods which are responsible to display in screen/console.
 */
public class UI {

	Cart cart = new Cart();
	private int ch = 0;
	Console logger = new Console();

	public UI() throws Exception {
		menu();
	}

	public void firstScreen() {
		logger.writeInfo("  " + "Hello user please select your choice!!!");
		logger.writeInfo("  ");
		logger.writeInfo("1.New Equipment Business" + "[NEB]");
		logger.writeInfo("2.Service Equipment Business" + "[SEB]");
		logger.writeInfo("0.Exit");

	}

	public void storeElevatorsDetails() {
		logger.writeInfo("1.display showroom elevators");
		logger.writeInfo("2.display elevators in cart");
		logger.writeInfo("3.Add Elevator to Cart");
		logger.writeInfo("4.Remove Elevators From Cart");
		logger.writeInfo("0. Exit");
	}

	public void menu() throws Exception {
		do {
			firstScreen();
			getUserInput();

			// Implemented single responsibility in SOLID principles.
			switch (ch) {
			case 1:
				columnHeader();
				displayNewElevators();
				getUserInput();
				futureChoice();
				break;

			case 2:
				columnHeaders();
				ServiceElevators();
				getUserInput();
				ServiceChoice();
				break;

			case 0:
				System.exit(0);
				break;

			default:
				break;
			}
		} while (ch != 0);
	}

	private void ServiceElevators() {
		logger.writeInfo("1.OTIS");
		logger.writeInfo("2.ThyssenKrupp");
		logger.writeInfo("3.Hitachi");
		logger.writeInfo("4.OtherElevatorModels");

	}

	// user to choose the type of elevator and there subcategory
	private void futureChoice() throws Exception {
		switch (ch) {
		case 1:
			logger.writeInfo("Hey User please select your choice of connected elevator!!!");
			logger.writeInfo("EqupNo" + "\t " + "ElevatorName" + "\t\t" + "Features");
			logger.writeInfo(
					"---------------------------------------------------------------------------------------------------------------");
			displayConnectedElevators();
			userIndication();
			storeElevatorsDetails();
			getUserInput();
			innerChoice();

			break;

		case 2:
			logger.writeInfo("Hey user please select your choice of non-connected elevator ");
			logger.writeInfo("EqupNo" + "\t " + "ElevatorName" + "\t\t" + "Features");
			logger.writeInfo(
					"---------------------------------------------------------------------------------------------------------------");
			displayNonConnectedElevators();
			// startScreen();
			userIndication();
			storeElevatorsDetails();
			getUserInput();
			innerChoice();
			break;
		case 3:
			logger.writeInfo("Hey user please select your choice of DigitalExperience elevator ");
			logger.writeInfo("EqupNo" + "\t " + "ElevatorName" + "\t\t" + "Features");
			logger.writeInfo(
					"---------------------------------------------------------------------------------------------------------------");
			displayDigitalElevators();
			// startScreen();
			userIndication();
			storeElevatorsDetails();
			getUserInput();
			innerChoice();
			break;
		default:
			break;
		}

	}

	// provides the user to choose for which elevators the kone service is
	// needed
	private void ServiceChoice() {
		switch (ch) {
		case 1:
			logger.writeInfo("OTIS serviceChoice ");
			logger.writeInfo("Customer signed agreement with kone elevators for servicing OTIS elevator");
			logger.writeInfo(
					"Thankyou for using kone services and products,we look forward for your co-operation in future");
			break;

		case 2:
			logger.writeInfo("ThyssenKrupp serviceChoice ");
			logger.writeInfo("Customer signed agreement with kone elevators for servicing ThyssenKrupp elevator");
			logger.writeInfo(
					"Thankyou for using kone services and products,we look forward for your co-operation in future");
			break;
		case 3:
			logger.writeInfo("Hitachi serviceChoice ");
			logger.writeInfo("Customer signed agreement with kone elevators for servicing Hitachi elevator");
			logger.writeInfo(
					"Thankyou for using kone services and products,we look forward for your co-operation in future");
			break;
		case 4:
			logger.writeInfo("other elevator models");
			CustomerDetails();
			break;
		default:
			break;

		}
	}

	// take the details of customers
	private void CustomerDetails() {
		Scanner sc = new Scanner(System.in);

		logger.writeInfo("please enter the other elevator model which is looking for kone services");
		String elevatormodel = sc.nextLine();
		logger.writeInfo("please enter the customername");
		String customername = sc.nextLine();
		logger.writeInfo("please enter the customer mobile number");
		long mobileNo = sc.nextLong();
		logger.writeInfo("ElevatorModel:" + elevatormodel + "--" + "CustomerName:" + customername + "--" + "mobileNo:"
				+ mobileNo);
		logger.writeInfo("Customer signed agreement with kone elevators for servicing" + "  " + elevatormodel + " "
				+ "elevator");
		logger.writeInfo(
				"Thankyou for using kone services and products,we look forward for your co-operation in future");

	}

	// inner choice method is used to add or remove elevator from the
	// elevatorKart.
	private void innerChoice() throws Exception {
		switch (ch) {
		case 1:
			displayStoreElevators();
			break;

		case 2:
			showCart();
			break;

		case 3:
			addElevatorToCart();
			showCart();
			break;
		case 4:
			removeElevatorFromCart();
			break;
		default:

			break;
		}
	}

	// display the all elevators details
	private void displayStoreElevators() throws Exception {

		ElevatorDaoImpl elevatordaoimpl = new ElevatorDaoImpl();
		List<Elevator> elevatorData = elevatordaoimpl.elevatorData();
		for (Elevator elevatorDataLoop : elevatorData) {
			System.out.println("Elevator Name" + elevatorDataLoop.getEname());
			System.out.println("Elevator Price" + elevatorDataLoop.getPrice());
			System.out.println("Elevator stock" + elevatorDataLoop.getStock());
			System.out.println("Elevator features" + elevatorDataLoop.getFeatures());
		}
	}

	private void displayDigitalElevators() throws Exception {
		ElevatorDaoImpl elevatordaoimpl = new ElevatorDaoImpl();
		List<Elevator> elevatorData = elevatordaoimpl.DXelevatorData();
		for (Elevator elevatorDataLoop : elevatorData) {
			System.out.println("Elevator Id" + elevatorDataLoop.getEno());
			System.out.println("Elevator Name" + elevatorDataLoop.getEname());
			System.out.println("Elevator features" + elevatorDataLoop.getFeatures());
		}

	}

	// display the NonconnectedElevators with eid and eName
	private void displayNonConnectedElevators() throws Exception {
		ElevatorDaoImpl elevatordaoimpl = new ElevatorDaoImpl();
		List<Elevator> elevatorData = elevatordaoimpl.NonConnectedelevatorData();
		for (Elevator elevatorDataLoop : elevatorData) {
			System.out.println("Elevator Id" + elevatorDataLoop.getEno());
			System.out.println("Elevator Name" + elevatorDataLoop.getEname());
			System.out.println("Elevator features" + elevatorDataLoop.getFeatures());
		}
	}

	// take the user input from console
	private int getUserInput() {
		try {
			Scanner in = new Scanner(System.in);
			ch = Integer.parseInt(in.nextLine());
		} catch (Exception e) {
			logger.writeError("please enter a valid value");
			getUserInput();
			// System.exit(0);

		}

		return ch;

	}

	// display the types in NEB
	private void displayNewElevators() {
		logger.writeInfo("1.Connected Elevators");
		logger.writeInfo("2.Non-Connected Elevators");
		logger.writeInfo("3.Digital Experience Elevators");

	}

	private void columnHeaders() {
		logger.writeInfo("please select the type of elevator which need service");
		logger.writeInfo("----------------------------------------------------------");
	}

	private void columnHeader() {
		logger.writeInfo("please select the type of elevator");
		logger.writeInfo("-------------------------------------");
	}

	private void userIndication() {
		logger.writeInfo("   ");
		logger.writeInfo("first choose add or remove option followed by select elevator");
		logger.writeInfo("   ");
	}

	private void displayConnectedElevators() throws Exception {
		ElevatorDaoImpl elevatordaoimpl = new ElevatorDaoImpl();
		List<Elevator> elevatorData = elevatordaoimpl.ConnectedelevatorData();
		for (Elevator elevatorDataLoop : elevatorData) {
			System.out.println("Elevator Id" + elevatorDataLoop.getEno());
			System.out.println("Elevator Name" + elevatorDataLoop.getEname());
			System.out.println("Elevator features" + elevatorDataLoop.getFeatures());
		}
	}

	private void addElevatorToCart() {
		//scanner class implementation not needed
		int eno = getUserInput();
		cart.addElevatorToCartByENO(eno);
	}

	private void showCart() {
		cart.printCartItems();
	}

	private void removeElevatorFromCart() {
		int eno = getUserInput();
		cart.removeElevatorByENO(eno);
	}

}
