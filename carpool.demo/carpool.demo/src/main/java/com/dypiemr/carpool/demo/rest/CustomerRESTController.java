package com.dypiemr.carpool.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.dypiemr.carpool.demo.entity.Customer;
import com.dypiemr.carpool.demo.exception.NotFoundException;
import com.dypiemr.carpool.demo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRESTController {

	private CustomerService customerService;
	
	@Autowired
	public CustomerRESTController(CustomerService theCustomerService) {
		customerService = theCustomerService;
	}
	
	// expose "/customer" and return list of customer
	@GetMapping("/customer")
	//defines a cache for method's return value  
	@Cacheable(value="customer")  
	public List<Customer> findAll() {
		return customerService.findAll();
	}
	// add mapping for GET /customer/{customerId}
	
		@GetMapping("/customer/{customerId}")
		public Customer getCustomer(@PathVariable int customerId) {
			
			Customer theCustomer = customerService.findById(customerId);
			
			if (theCustomer == null) {
				throw new NotFoundException("Customer not found with id " + customerId);
			}
			
			return theCustomer;
		}
		
		// add mapping for POST /customer - add new customer
		
		@PostMapping("/customer")
		public Customer addCustomer(@RequestBody Customer theCustomer) {
			
			// also just in case they pass an id in JSON ... set id to 0
			// this is to force a save of new item ... instead of update
			
			theCustomer.setId(0);
			
			customerService.save(theCustomer);
			
			return theCustomer;
		}
		// add mapping for PUT /customer - update existing customer
		
		@PutMapping("/customer")
		public ResponseEntity<Customer> updateCustomer(@RequestBody Customer theCustomer) {
			try {
			customerService.save(theCustomer);
			}
			catch(Exception e) {
				return new ResponseEntity<Customer>(theCustomer,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<Customer>(theCustomer,HttpStatus.OK);
		}
		// add mapping for DELETE /customer/{customerId} - delete customer
		
		@DeleteMapping("/customer/{customerId}")
		public String deleteCustomer(@PathVariable int customerId) {
			
			Customer tempCustomer = customerService.findById(customerId);
			
			// throw exception if null
			
			if (tempCustomer == null) {
				throw new NotFoundException("Customer not found with id " + customerId);
			}
			
			customerService.deleteById(customerId);
			
			return "Deleted customer id - " + customerId;
		}

		


	
}


