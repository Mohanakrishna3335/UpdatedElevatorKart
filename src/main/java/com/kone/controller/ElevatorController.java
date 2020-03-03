package com.kone.controller;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kone.Implementation.Cart;
import com.kone.model.AllElevators;
import com.kone.model.Elevator;
import com.kone.model.KoneConnectedElevators;
import com.kone.model.KoneDigitalExperience;
import com.kone.model.KoneNonConnectedElevators;
import com.kone.service.impl.ElevatorServiceImple;

@Path("/elevators")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
//all the get and post requests for ElevatorsKart
public class ElevatorController {
	ElevatorServiceImple elevatorserviceimpl = new ElevatorServiceImple();
	Cart cart = new Cart();

	@Path("/allElevators")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	// Display allElevators Data
	public Response displayStoreElevator() throws Exception {
		List<Elevator> elevatorsList = elevatorserviceimpl.displayStoreElevator();
		AllElevators allElevators = new AllElevators();
		allElevators.setAllelevators(elevatorsList);
		return Response.status(Response.Status.OK).entity(allElevators).type(MediaType.APPLICATION_JSON).build();
	}

	@Path("/connectedElevators")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	// Display connectedElevators data
	public Response displayConnectedElevator() throws Exception {
		List<Elevator> connectedelevatorsList = elevatorserviceimpl.displayConnectedElevator();
		KoneConnectedElevators koneconnectedelevators = new KoneConnectedElevators();
		koneconnectedelevators.setKoneConnectedelevators(connectedelevatorsList);
		return Response.status(Response.Status.OK).entity(koneconnectedelevators).type(MediaType.APPLICATION_JSON)
				.build();
	}

	@Path("/nonConnectedElevators")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	// Display the nonConectedElevators data
	public Response displayNonConnectedElevator() throws Exception {
		List<Elevator> nonconnectedelevatorsList = elevatorserviceimpl.displayNonConnectedElevator();
		KoneNonConnectedElevators konenonconnectedelevators = new KoneNonConnectedElevators();
		konenonconnectedelevators.setKoneNonConnectedelevators(nonconnectedelevatorsList);
		return Response.status(Response.Status.OK).entity(konenonconnectedelevators).type(MediaType.APPLICATION_JSON)
				.build();
	}

	@Path("/digitalElevators")
	@GET
	// Display the DX elevators data
	public Response displayDigitalElevator() throws Exception {
		List<Elevator> digitalelevatorsList = elevatorserviceimpl.displayDigitalElevator();
		KoneDigitalExperience konedigitalexperience = new KoneDigitalExperience();
		konedigitalexperience.setKonedigitalexperience(digitalelevatorsList);
		return Response.status(Response.Status.OK).entity(konedigitalexperience).type(MediaType.APPLICATION_JSON)
				.build();

	}

	@POST
	@Path("/addNewElevator")
	@Consumes(MediaType.APPLICATION_JSON) // specifies the request body content
	@Produces(MediaType.APPLICATION_JSON)
	// Post method to push the data to DB
	public Response addElevator(Elevator elevator) throws Exception {

		System.out.println("$$$$$$" + elevator.getEno());
		System.out.println(elevator.getEname());
		System.out.println(elevator.getEtype());
		System.out.println(elevator.getFeatures());
		System.out.println(elevator.getPrice());
		System.out.println(elevator.getStock());
	    elevatorserviceimpl.addElevator(elevator);
		
		return Response.status(Response.Status.OK).entity("data inserted").type(MediaType.APPLICATION_JSON).build();

	}

}

/*
 * @POST
 * 
 * @Path("/addElevators")
 * 
 * @Produces(MediaType.APPLICATION_JSON)
 * 
 * @Consumes(MediaType.APPLICATION_JSON) public Response
 * addElevatorToCart(Elevator elevator) { //
 * cart.addElevatorToCartByENO(e.getEno()); System.out.println("add elevators");
 * List<Elevator> cartItems = cart.addElevatorToCartByENO(elevator.getEno());
 * System.out.println(cartItems.toString()); AddElevators addelevators = new
 * AddElevators(); addelevators.setAddelevators(cartItems); return
 * Response.status(Response.Status.OK).entity(addelevators).type(MediaType.
 * APPLICATION_JSON).build(); }
 */

/*
 * int equipmentNumber = elevator.getEno(); String elevatorName
 * =elevator.getName(); String elevatorType=elevator.getEtype(); String
 * elevatorFeatures= elevator.getFeatures(); int
 * elevatorPrice=elevator.getPrice(); int elevatorStock=elevator.getStock();
 */
/*
 * @GET
 * 
 * @Path("/showCart")
 * 
 * @Produces(MediaType.APPLICATION_JSON) public Response showCart() { //
 * cart.printCartItems(); List<Elevator> cartItems = cart.printCartItems();
 * System.out.println(cartItems); ShowElevators showelevators = new
 * ShowElevators(); showelevators.setShowelevators(cartItems); return
 * Response.status(Response.Status.OK).entity(showelevators).type(MediaType.
 * APPLICATION_JSON).build(); }
 */