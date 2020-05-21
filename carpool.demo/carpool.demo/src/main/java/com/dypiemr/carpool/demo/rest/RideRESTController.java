package com.dypiemr.carpool.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dypiemr.carpool.demo.entity.Ride;
import com.dypiemr.carpool.demo.service.RideService;

@RestController
@RequestMapping("/api")
public class RideRESTController {

	private RideService rideService;
	
	@Autowired
	public RideRESTController(RideService theRideService) {
		rideService = theRideService;
	}
	
	// expose "/ride" and return list of rides
	@GetMapping("/ride")
	public List<Ride> findAll() {
		return rideService.findAll();
	}
	// add mapping for GET /ride/{rideId}
	
		@GetMapping("/ride/{rideId}")
		public Ride getCustomer(@PathVariable int rideId) {
			
			Ride theRide = rideService.findById(rideId);
			
			if (theRide == null) {
				throw new RuntimeException("Ride id not found - " + rideId);
			}
			
			return theRide;
		}
		
		// add mapping for POST /customer - add new customer
		
		@PostMapping("/ride")
		public Ride addRide(@RequestBody Ride theRide) {
			
			// also just in case they pass an id in JSON ... set id to 0
			// this is to force a save of new item ... instead of update
			
			theRide.setId(0);
			
			rideService.save(theRide);
			
			return theRide;
		}
		// add mapping for PUT /ride - update existing ride
		
		@PutMapping("/ride")
		public Ride updateRide(@RequestBody Ride theRide) {
			
			rideService.save(theRide);
			
			return theRide;
		}
		// add mapping for DELETE /ride/{rideId} - delete ride
		
		@DeleteMapping("/ride/{rideId}")
		public String deleteRide(@PathVariable int rideId) {
			
			Ride tempRide = rideService.findById(rideId);
			
			// throw exception if null
			
			if (tempRide == null) {
				throw new RuntimeException("Ride id not found - " + rideId);
			}
			
			rideService.deleteById(rideId);
			
			return "Deleted ride id - " + rideId;
		}

	
		
			@GetMapping("/createride/{customerId}/{rideId}")
			public Ride createride(@PathVariable int customerId,@PathVariable int rideId) {
				Ride theRide = rideService.findById(rideId);
				if (theRide == null) {
					throw new RuntimeException("Ride id not found - " + rideId);
				}
				int rideNo = rideService.countRides();
				rideService.saveRider(rideId,customerId);
				System.out.println("Ride saved"+rideNo);
				return theRide;
			}
	
}



