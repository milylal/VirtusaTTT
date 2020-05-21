package com.dypiemr.carpool.demo.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Customer_Rides_PK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int customerId;
	private int rideId;
	
	public int getUserId() {
		return customerId;
	}
	public void setUserId(int customerId) {
		this.customerId = customerId;
	}
	public int getRideId() {
		return rideId;
	}
	public void setRideId(int rideId) {
		this.rideId = rideId;
	}	
}
