package com.kone.controller;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kone.service.impl.ElevatorServiceImple;

@Path("/elevators")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ElevatorResource {
	ElevatorServiceImple eleser = new ElevatorServiceImple();

	@Path("/elevatortypes")
	@GET
	public Response displayStoreElevators() {
		// return
		// Response.status(Response.Status.OK).entity("Hello").type(MediaType.APPLICATION_JSON).build();
		System.out.println("entered inside method");
		return Response.status(Response.Status.OK).entity("Hello").type(MediaType.APPLICATION_JSON).build();
	}

	@Path("/elevators/connected")
	@GET
	public Response displayConnectedElevators() {
		System.out.println("entered inside connected");
		return Response.status(Response.Status.OK).entity("connected").type(MediaType.APPLICATION_JSON).build();
	}

	@Path("/elevators/nonconnected")
	@GET
	public Response displayNonConnectedElevators() {
		//return eleser.displayNonConnectedElevators();
		return Response.status(Response.Status.OK).entity("nonconnected").type(MediaType.APPLICATION_JSON).build();
	}

	@Path("/elevators/digitalelevators")
	@GET
	public Object displayDigitalElevators() {
		return eleser.displayDigitalElevators();
	}

}