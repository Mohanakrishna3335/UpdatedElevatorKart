package com.kone.settings;
import com.kone.model.Elevator;
import java.util.ArrayList;
import java.util.List;

/*
 *  provides information about our digitalExperience cart.
 */

public class DigitalExperience{
    private List<Elevator> delevators = new ArrayList<Elevator>();

    public DigitalExperience () {
        this.initStoreItems();
    }
    
    public List<Elevator> getDigitalExperience() {
        return delevators;
    }
    
    public void initStoreItems() {
    	
        String [] elevatorNames = {"DX-KCECPUC14.1"};
        int [] elevatorPrice = {11};
        int [] stock = {32};
        String[] elevatorFeatures ={"it is a new digital platform for kone elvators which provides additional and advanced peopleflow"};
        
        for (int i=0; i < elevatorNames.length; i++) {
            this.delevators.add(new Elevator(i+30, elevatorNames[i], elevatorPrice[i], stock[i],elevatorFeatures[i]));
        }
    }
}
