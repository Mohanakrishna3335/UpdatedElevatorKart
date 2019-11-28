package com.kone.service;

import java.util.List;

import com.kone.model.Elevator;

public interface ElevatorService {
	public List<Elevator> displayStoreElevator() throws Exception;

	public List<Elevator> displayConnectedElevator() throws Exception;

	public List<Elevator> displayNonConnectedElevator() throws Exception;

	public List<Elevator> displayDigitalElevator() throws Exception;
}
