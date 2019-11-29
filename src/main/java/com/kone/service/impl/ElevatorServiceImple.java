package com.kone.service.impl;

import java.util.List;
import com.kone.dao.impl.ElevatorDaoImpl;
import com.kone.model.Elevator;
import com.kone.service.ElevatorService;

public class ElevatorServiceImple implements ElevatorService {
	ElevatorDaoImpl elevatordaoimpl = new ElevatorDaoImpl();

	public List<Elevator> displayConnectedElevator() throws Exception {
		List<Elevator> elevatorData = elevatordaoimpl.ConnectedelevatorData();
		if (elevatorData != null) {
			for (Elevator elevatorDataLoop : elevatorData) {
				System.out.println("Elevator Id" + elevatorDataLoop.getEno());
				System.out.println("Elevator Name" + elevatorDataLoop.getName());
				System.out.println("Elevator features" + elevatorDataLoop.getFeatures());
			}
		}
		return elevatorData;
	}

	public List<Elevator> displayNonConnectedElevator() throws Exception {
		List<Elevator> elevatorData = elevatordaoimpl.NonConnectedelevatorData();
		if (elevatorData != null) {
			for (Elevator elevatorDataLoop : elevatorData) {
				System.out.println("Elevator Id" + elevatorDataLoop.getEno());
				System.out.println("Elevator Name" + elevatorDataLoop.getName());
				System.out.println("Elevator features" + elevatorDataLoop.getFeatures());
			}
		}
		return elevatorData;
	}

	public List<Elevator> displayDigitalElevator() throws Exception {
		List<Elevator> elevatorData = elevatordaoimpl.DXelevatorData();
		if (elevatorData != null) {
			for (Elevator elevatorDataLoop : elevatorData) {
				System.out.println("Elevator Id" + elevatorDataLoop.getEno());
				System.out.println("Elevator Name" + elevatorDataLoop.getName());
				System.out.println("Elevator features" + elevatorDataLoop.getFeatures());
			}
		}
		return elevatorData;

	}

	public List<Elevator> displayStoreElevator() throws Exception {

		List<Elevator> elevatorData = elevatordaoimpl.elevatorData();
		if (elevatorData != null) {
			for (Elevator elevatorDataLoop : elevatorData) { //
				System.out.println("Elevator Id" + elevatorDataLoop.getEno());
				System.out.println("Elevator Name" + elevatorDataLoop.getName());
				System.out.println("Elevator Price" + elevatorDataLoop.getPrice());
				System.out.println("Elevator stock" + elevatorDataLoop.getStock());
				System.out.println("Elevator features" + elevatorDataLoop.getFeatures());
			}
		}
		return elevatorData;

	}

	
}
