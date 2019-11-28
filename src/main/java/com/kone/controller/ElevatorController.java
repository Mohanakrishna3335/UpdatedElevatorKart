package com.kone.controller;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.kone.model.AllElevators;
import com.kone.model.Elevator;
import com.kone.model.KoneConnectedElevators;
import com.kone.model.KoneDigitalExperience;
import com.kone.model.KoneNonConnectedElevators;
import com.kone.service.impl.ElevatorServiceImple;

@Path("/elevators")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ElevatorController {
	ElevatorServiceImple eleser = new ElevatorServiceImple();
	ElevatorServiceImple elevatorserviceimpl = new ElevatorServiceImple();

	@Path("/allelevators")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response displayStoreElevator() throws Exception {
		List<Elevator> elevatorsList = elevatorserviceimpl.displayStoreElevator();
		AllElevators allElevators = new AllElevators();
		allElevators.setAllelevators(elevatorsList);
		return Response.status(Response.Status.OK).entity(allElevators).type(MediaType.APPLICATION_JSON).build();
	}

	@Path("/connectedelevators")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response displayConnectedElevator() throws Exception {
		List<Elevator> connectedelevatorsList = elevatorserviceimpl.displayConnectedElevator();
		KoneConnectedElevators koneconnectedelevators = new KoneConnectedElevators();
		koneconnectedelevators.setKoneConnectedelevators(connectedelevatorsList);
		return Response.status(Response.Status.OK).entity(koneconnectedelevators).type(MediaType.APPLICATION_JSON)
				.build();
	}

	@Path("/nonconnectedelevators")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response displayNonConnectedElevator() throws Exception {
		List<Elevator> nonconnectedelevatorsList = elevatorserviceimpl.displayNonConnectedElevator();
		KoneNonConnectedElevators konenonconnectedelevators = new KoneNonConnectedElevators();
		konenonconnectedelevators.setKoneNonConnectedelevators(nonconnectedelevatorsList);
		return Response.status(Response.Status.OK).entity(konenonconnectedelevators).type(MediaType.APPLICATION_JSON)
				.build();
	}

	@Path("/elevators/digitalelevators")
	@GET
	public Response displayDigitalElevator() throws Exception {
		List<Elevator> digitalelevatorsList = elevatorserviceimpl.displayDigitalElevator();
		KoneDigitalExperience konedigitalexperience = new KoneDigitalExperience();
		konedigitalexperience.setKonedigitalexperience(digitalelevatorsList);
		return Response.status(Response.Status.OK).entity(konedigitalexperience).type(MediaType.APPLICATION_JSON)
				.build();

	}

}