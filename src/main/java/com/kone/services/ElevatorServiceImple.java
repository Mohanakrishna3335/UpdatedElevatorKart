package com.kone.services;

import java.util.List;

import com.kone.model.Elevator;
import com.kone.repository.ConnectedElevators;
import com.kone.repository.DXElevatorData;
import com.kone.repository.DataOfElevatorService;
import com.kone.repository.NonConnectedElevatorData;

public class ElevatorServiceImple implements ElevatorService {

	public Object displayConnectedElevators() {
		ConnectedElevators dataOfConnectedElevator = new ConnectedElevators();
		List<Elevator> elevatorData = dataOfConnectedElevator.ConnectedelevatorData();
		for (Elevator elevatorDataLoop : elevatorData) {
			System.out.println("Elevator Id" + elevatorDataLoop.getEno());
			System.out.println("Elevator Name" + elevatorDataLoop.getName());
			System.out.println("Elevator features" + elevatorDataLoop.getFeatures());
		}
		return elevatorData;
	}

	@Override
	public Object displayNonConnectedElevators() {
		NonConnectedElevatorData dataOfNonConnectedElevator = new NonConnectedElevatorData();
		List<Elevator> elevatorData = dataOfNonConnectedElevator.NonConnectedelevatorData();
		for (Elevator elevatorDataLoop : elevatorData) {
			System.out.println("Elevator Id" + elevatorDataLoop.getEno());
			System.out.println("Elevator Name" + elevatorDataLoop.getName());
			System.out.println("Elevator features" + elevatorDataLoop.getFeatures());
		}
		return elevatorData;
	}

	@Override
	public Object displayDigitalElevators() {
		DXElevatorData dataOfDXElevator = new DXElevatorData();
		List<Elevator> elevatorData = dataOfDXElevator.DXelevatorData();
		for (Elevator elevatorDataLoop : elevatorData) {
			System.out.println("Elevator Id" + elevatorDataLoop.getEno());
			System.out.println("Elevator Name" + elevatorDataLoop.getName());
			System.out.println("Elevator features" + elevatorDataLoop.getFeatures());
		}
		return elevatorData;

	}

	@Override
	public Object displayStoreElevators() {
		DataOfElevatorService dataOfElevatorService = new DataOfElevatorService();
		List<Elevator> elevatorData = dataOfElevatorService.elevatorData();
		for (Elevator elevatorDataLoop : elevatorData) {
			// System.out.println("Elevator Id"+elevatorDataLoop.getEid());
			System.out.println("Elevator Name" + elevatorDataLoop.getName());
			System.out.println("Elevator Price" + elevatorDataLoop.getPrice());
			System.out.println("Elevator stock" + elevatorDataLoop.getStock());
			System.out.println("Elevator features" + elevatorDataLoop.getFeatures());
		}
		return elevatorData;

	}

}
