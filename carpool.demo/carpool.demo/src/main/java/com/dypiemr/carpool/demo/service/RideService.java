package com.dypiemr.carpool.demo.service;

import java.util.List;

import com.dypiemr.carpool.demo.entity.Ride;

public interface RideService {
	 public List<Ride> findAll();
		
		public Ride findById(int theId);
		
		public void save(Ride theRide);
		public void deleteById(int theId);
		void saveRider(int rideId,int userId);
		void payRide(int rideId,int userId);
		int countRides();

}
