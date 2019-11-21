package com.kone.settings;

import com.kone.model.Elevator;
import java.util.ArrayList;
import java.util.List;

/*
 *  provides information about NonConnectedElevators cart.
 */

public class NonConnectedElevators {
	private List<Elevator> selevators = new ArrayList<Elevator>();

	public NonConnectedElevators() {
		this.initStoreItems();
	}

	public List<Elevator> getNonConnectedElevators() {
		return selevators;
	}

	public void initStoreItems() {

		String[] elevatorNames = { "I-Mono", "U-Mono" };
		int[] elevatorPrice = { 6, 7 };
		int[] stock = { 42, 35 };
		String[] elevatorFeatures = { "1.Machine room-less elevator for residential buildings 2. gearless technology",
				"1.Machine-room-less elevator for residential and commerical specific building in the urban space" };
		String[] elevatorType = { "Non-Connected", "Non-Connected" };
		for (int i = 0; i < elevatorNames.length; i++) {
			this.selevators.add(new Elevator(i + 20, elevatorNames[i], elevatorPrice[i], stock[i], elevatorFeatures[i],
					elevatorType[i]));
		}
	}
}