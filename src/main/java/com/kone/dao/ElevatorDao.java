package com.kone.dao;

import java.util.List;

import com.kone.model.Elevator;

public interface ElevatorDao {

	public List<Elevator> elevatorData() throws Exception;

	public List<Elevator> ConnectedelevatorData() throws Exception;

	public List<Elevator> NonConnectedelevatorData() throws Exception;

	public List<Elevator> DXelevatorData() throws Exception;

	public void addElevator(Elevator elevator) throws Exception;
}
