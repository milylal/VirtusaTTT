package com.dypiemr.carrental.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import com.dypiemr.carrental.model.RentalModel;
import com.dypiemr.carrental.repository.RentalRepository;


@RestController
@RequestMapping()
public class RentalController {
	@Autowired
	RentalRepository repository;
	public RentalRepository getRepository() {
        return repository;
    }
 
    public void setRepository(RentalRepository repository) {
        this.repository = repository;
    }
	// expose "/getCars" and return list of series
	@GetMapping("/getCars")
	  
	public ResponseEntity<List<RentalModel>> getAllCars() {
        return ResponseEntity.ok(repository.findAll());
    }
	// add mapping for GET /getCar?id=<carId>
	
		@GetMapping("/getCar")
		ResponseEntity<RentalModel> getCarById(@RequestParam(value="id") long carId) {
			Optional <RentalModel> rentalResponse =  repository.findById(carId);

	        return ResponseEntity.ok(rentalResponse.get());
	    }
    
	// add mapping for POST /saveCar- add new car
		
		@PostMapping(value = "/saveCar",consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
		public ResponseEntity<Object> createRentals(@RequestBody RentalModel rental) {
			RentalModel savedRentals = repository.save(rental);

			//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedRental.getId()).toUri();

			return ResponseEntity.ok(savedRentals);

		}
		// add mapping for PUT /editCar?id=<carId> - update existing rentals
		
		@PutMapping(value="/editCar",consumes={ MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
		public ResponseEntity<Object> editRentals(@RequestParam(value="id") long carId, @RequestBody RentalModel rental) {
			Optional <RentalModel> rentalResponse =  repository.findById(carId);
			if (rentalResponse.isPresent()){
            RentalModel existingCar = rentalResponse.get();
			existingCar.setCarModel(existingCar.getCarModel());
            existingCar.setCarNo(existingCar.getCarNo());
			existingCar.setStatus(existingCar.getStatus());
			RentalModel savedRentals = repository.save(rental);

			//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					//.buildAndExpand(savedRentals.getId()).toUri();

			return ResponseEntity.ok(savedRentals); }
			else {
				return ResponseEntity.notFound().build();
			}

		}
		// add mapping for DELETE /deleteCar?id=<carId> - delete retals
		
		@DeleteMapping("/deleteCar")
		ResponseEntity<Long> deleteRental(@RequestParam(value="id") long carId) {
            repository.deleteById(carId);
        return ResponseEntity.ok(carId);
    }
		


	
}

