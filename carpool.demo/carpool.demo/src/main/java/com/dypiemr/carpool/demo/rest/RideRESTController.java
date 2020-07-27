package com.dypiemr.carpool.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dypiemr.carpool.demo.entity.Customer;
import com.dypiemr.carpool.demo.entity.Ride;
import com.dypiemr.carpool.demo.exception.NotFoundException;
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
				throw new NotFoundException("Ride nor found with id " + rideId);
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
		public ResponseEntity<Ride> updateRide(@RequestBody Ride theRide) {
			try {
			rideService.save(theRide);
			}
			catch(Exception e) {
				return new ResponseEntity<Ride>(theRide,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<Ride>(theRide,HttpStatus.OK);
		}
		// add mapping for DELETE /ride/{rideId} - delete ride
		
		@DeleteMapping("/ride/{rideId}")
		public String deleteRide(@PathVariable int rideId) {
			
			Ride tempRide = rideService.findById(rideId);
			
			// throw exception if null
			
			if (tempRide == null) {
				throw new NotFoundException("Ride nor found with id " + rideId);
			}
			
			rideService.deleteById(rideId);
			
			return "Deleted ride id - " + rideId;
		}

	
		
			@GetMapping("/viewride/{customerId}")
			public Ride createride(@PathVariable int customerId,@RequestParam("rideId") int rideId) {
				Ride theRide = rideService.findById(rideId);
				if (theRide == null) {
					throw new NotFoundException("Ride nor found with id " + rideId);
				}
				return theRide;
			}
			
			@GetMapping("/saveRider")
			public void saveRider(@RequestParam("rideId") int rideId,@RequestParam("customerId") int customerId)  {
				Ride theRide = rideService.findById(rideId);
				if (theRide == null) {
					throw new NotFoundException("Ride nor found with id " + rideId);
				}
				else {
				rideService.saveRider(rideId, customerId);
				int rideNo = rideService.countRides();
				System.out.println("Ride saved"+rideNo);
				}
			}
			
			@GetMapping("/payRide")
			public void payRide(@RequestParam("rideId") int rideId,@RequestParam("customerId") int customerId)  {
				rideService.payRide(rideId, customerId);
				System.out.println("Paid for the ride");
			}
			
			
			
	
}


