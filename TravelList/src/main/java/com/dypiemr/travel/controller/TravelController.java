package com.dypiemr.travel.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.dypiemr.travel.model.Travel;
import com.dypiemr.travel.repository.TravelRepository;


@RestController
@RequestMapping()
public class TravelController {
	@Autowired
	TravelRepository repository;
	public TravelRepository getRepository() {
        return repository;
    }
 
    public void setRepository(TravelRepository repository) {
        this.repository = repository;
    }
	
	@GetMapping("/travel")
	  
	public ResponseEntity<List<Travel>> getAllTravel() {
        return ResponseEntity.ok(repository.findAll());
    }
	
	
		@GetMapping("/travel/{id}")
		public ResponseEntity<Travel> getTravelById(@PathVariable Long id) {
	        return ResponseEntity.ok(repository.findById(id).get());
	    }
		
		@PostMapping(value = "/addTravel",consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
		public ResponseEntity<String> createTravel(@RequestBody Travel travellist) {
			Travel savedTravel = repository.save(travellist);

			//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedSeries.getId()).toUri();

			return ResponseEntity.ok("Travel Added Successfully !");

		}
	
		
		@PutMapping(value="/travel",consumes={ MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
		public ResponseEntity<String> updateTravel(@PathVariable Long id,@RequestBody Travel travellist) {
			Travel savedTravel = repository.save(travellist);

			//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					//.buildAndExpand(savedSeries.getId()).toUri();

			return ResponseEntity.ok("Travel Updated Successfully !"+ id);

		}
		// add mapping for DELETE /delete/{id} - delete series
		
		@DeleteMapping("/delete/{id}")
		ResponseEntity<String> deleteSeries(@PathVariable Long id) {
            repository.deleteById(id);
        return ResponseEntity.ok("Travel Deleted Successfully !"+ id);
    }
		


	
}
