package com.dypiemr.carpool.demo.dao;

import java.util.List;

import com.dypiemr.carpool.demo.entity.Ride;


public interface RideDAO {
	public List<Ride> findAll();
    public Ride findById(int theId);
	public void save(Ride theRide);
	public void deleteById(int theId);
	void saveRider(int rideId,int customerId);
	void payRide(int rideId,int customerId);
	int countRides();

}
