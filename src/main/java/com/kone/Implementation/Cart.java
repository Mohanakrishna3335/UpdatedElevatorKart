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
    
    public void addElevatorToCartByEID(int eid) {
       Elevator elevator = getElevatorByElevatorID(eid);
        addToCart(elevator);
    }

    private Elevator getElevatorByElevatorID(int eid) {
    	 Elevator elevator = null;
        List<Elevator> elevators = new Elevators().getElevators();
        List<Elevator> selevators= new NonConnectedElevators().getNonConnectedElevators();
        List<Elevator> delevators=new  DigitalExperience().getDigitalExperience();
        List<Elevator> allElevators=new ArrayList<Elevator>();
        
        
        for(Elevator elev: elevators){
        	allElevators.add(elev);
        }
        for(Elevator elev:selevators){
        	allElevators.add(elev);
        }
        for(Elevator elev:delevators){
        	allElevators.add(elev);
        }
      
        for (Elevator elev: allElevators) {
            if (elev.getEid() == eid) {
                elevator = elev;
               
                break;
            }
        }
        return elevator;
    }
  
//add elevators to the cart
    private void addToCart(Elevator elevator) {
        cartItems.add(elevator);
    }
//remove the elevator from the cart
    public void removeElevatorByEID(int eid) {
        Elevator elev = getElevatorByElevatorID(eid);
        cartItems.remove(elev);
    }
//print the elevator details
    public void printCartItems() {
        for (Elevator elev: cartItems) {
            logger.writeInfo(elev.getName()+" --> "+elev.getFeatures());
        }
    }
}

