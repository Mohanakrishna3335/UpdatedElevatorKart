package com.kone.settings;
import com.kone.model.Elevator;
import java.util.ArrayList;
import java.util.List;

/*
 *  provides information about our ConnectedElevators  cart.
 */

public class Elevators {
    private List<Elevator> elevators = new ArrayList<Elevator>();

    public Elevators () {
        this.initStoreItems();
    }
    
    public List<Elevator> getElevators() {
        return elevators;
    }
    
    public void initStoreItems() {
    	
        String [] elevatorNames = {"U-Galaxy kc-120", "U-Galaxy kc-210", "U-Galaxy kc-230E"};
        int[] elevatorPrice = {8, 9, 10};
        int [] stock = {72, 65, 45};
        String [] elevatorFeatures={"1. people count 2.temperature measure","1. people count 2.temperature measure 3.speed of the elevator 4.tensile strength of elevator","1.people count 2.temperature measure 3.speed of the elevator 4.tensile strength of elevator ,5.firedetection 6. level of elevator"};
        String[] elevatorType={"Connected","Connected","Connected"};
        
        for (int i=0; i < elevatorNames.length; i++) {
            this.elevators.add(new Elevator(i+10, elevatorNames[i], elevatorPrice[i], stock[i],elevatorFeatures[i],elevatorType[i]));
        }
    }

	
}

