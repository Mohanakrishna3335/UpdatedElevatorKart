package com.kone.settings;

import com.kone.model.Elevator;
import java.util.ArrayList;
import java.util.List;

/*
 *  provides information about our digitalExperience cart.
 */

public class DigitalExperience {
	private List<Elevator> delevators = new ArrayList<Elevator>();

	public DigitalExperience() {
		this.initStoreItems();
	}

	public List<Elevator> getDigitalExperience() {
		return delevators;
	}

	public void initStoreItems() {

		String[] elevatorNames = { "DX-KCECPUC14.1" };
		int[] elevatorPrice = { 11 };
		int[] stock = { 32 };
		String[] elevatorFeatures = {
				"1.advanced peopleflow 2.temperature measure 3.speed of the elevator 4.tensile strength of elevator ,5.firedetection 6. level of elevator" };
		String[] elevatorType = { "DX" };
		for (int i = 0; i < elevatorNames.length; i++) {
			this.delevators.add(new Elevator(i + 30, elevatorNames[i], elevatorPrice[i], stock[i], elevatorFeatures[i],
					elevatorType[i]));
		}
	}
}
