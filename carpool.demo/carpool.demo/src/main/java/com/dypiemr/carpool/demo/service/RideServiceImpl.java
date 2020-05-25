package com.dypiemr.carpool.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dypiemr.carpool.demo.dao.RideDAO;
import com.dypiemr.carpool.demo.entity.Ride;

@Service
public class RideServiceImpl implements RideService {

	private RideDAO rideDAO;
	
	@Autowired
	public RideServiceImpl(RideDAO theRideDAO) {
		rideDAO = theRideDAO;
	}
	
	@Override
	@Transactional
	public List<Ride> findAll() {
		return rideDAO.findAll();
	}

	@Override
	@Transactional
	public Ride findById(int theId) {
		return rideDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Ride theRide) {
		rideDAO.save(theRide);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		rideDAO.deleteById(theId);
	}

	@Override
	@Transactional
	public void saveRider(int rideId, int customerId) {
		// TODO Auto-generated method stub
		rideDAO.saveRider(rideId, customerId);
		
	}

	@Override
	@Transactional
	public int countRides() {
		// TODO Auto-generated method stub
		return rideDAO.countRides();
	}

	@Override
	@Transactional
	public void payRide(int rideId, int userId) {
		// TODO Auto-generated method stub
		rideDAO.payRide(rideId, userId);
		
	}

}

