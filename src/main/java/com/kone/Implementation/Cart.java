package com.kone.Implementation;

import java.util.ArrayList;
import java.util.List;
import com.kone.console.Console;
import com.kone.model.Elevator;
import com.kone.settings.DigitalExperience;
import com.kone.settings.Elevators;
import com.kone.settings.NonConnectedElevators;

//it contains features to add,remove and display elevators in cart
public class Cart {
	Console logger = new Console();
	List<Elevator> cartItems = new ArrayList<Elevator>();
	
	

	public List<Elevator> addElevatorToCartByENO(int eno) {
		Elevator elevator = getElevatorByEquipmentNO(eno);
		
		//List<Elevator> cartItems =addToCart(elevator);
		addToCart(elevator);
		System.out.println("entered inside cart"+cartItems.toString());
		return cartItems;
	}

	private Elevator getElevatorByEquipmentNO(int eno) {
		Elevator elevator = null;
		List<Elevator> elevators = new Elevators().getElevators();
		List<Elevator> selevators = new NonConnectedElevators().getNonConnectedElevators();
		List<Elevator> delevators = new DigitalExperience().getDigitalExperience();
		List<Elevator> allElevators = new ArrayList<Elevator>();

		for (Elevator elev : elevators) {
			allElevators.add(elev);
		}
		for (Elevator elev : selevators) {
			allElevators.add(elev);
		}
		for (Elevator elev : delevators) {
			allElevators.add(elev);
		}

		for (Elevator elev : allElevators) {
			if (elev.getEno() == eno) {
				elevator = elev;

				break;
			}
		}
		return elevator;
	}

	// add elevators to the cart
	private List<Elevator> addToCart(Elevator elevator) {
		cartItems.add(elevator);
		System.out.println("inside add to cart");
		return cartItems;
	}

	// remove the elevator from the cart
	public List<Elevator> removeElevatorByENO(int eno) {
		Elevator elev = getElevatorByEquipmentNO(eno);
		cartItems.remove(elev);
		return cartItems;
	}

	// print the elevator details
	public List<Elevator> printCartItems() {
		for (Elevator elev : cartItems) {
			logger.writeInfo(elev.getName() + " --> " + elev.getFeatures());
		}
		return cartItems;
	}
}
