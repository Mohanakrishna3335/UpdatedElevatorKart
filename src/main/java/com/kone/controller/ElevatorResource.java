package com.kone.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.kone.services.ElevatorServiceImple;

@Path("/elevators")
public class ElevatorResource {
	ElevatorServiceImple eleser = new ElevatorServiceImple();

	@GET
	@Produces("text/json")
	public Object displayStoreElevators() {
		return eleser.displayStoreElevators();
	}

	@Path("/elevators/connected")
	@GET
	@Produces("text/json")
	public Object displayConnectedElevators() {
		return eleser.displayConnectedElevators();
	}

	@Path("/elevators/nonconnected")
	@GET
	@Produces("text/json")
	public Object displayNonConnectedElevators() {
		return eleser.displayNonConnectedElevators();
	}

	@Path("/elevators/digitalelevators")
	@GET
	@Produces("text/json")
	public void displayDigitalElevators() {
		return;
	}

}
