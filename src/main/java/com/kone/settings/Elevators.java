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
        String [] elevatorFeatures={"it has 2 amazing features like people count and temperature measure","it has amazing features like people count, temperature measure,speed and tensile strength of elevator","it has amazing features like people count, temperature measure,speed , tensile strength ,firedetection and level of elevator"};
        
        for (int i=0; i < elevatorNames.length; i++) {
            this.elevators.add(new Elevator(i+10, elevatorNames[i], elevatorPrice[i], stock[i],elevatorFeatures[i]));
        }
    }

	
}

