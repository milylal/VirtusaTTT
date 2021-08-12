package com.dypiemr.webseries.controller;

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
import com.dypiemr.webseries.model.Series;
import com.dypiemr.webseries.repository.SeriesRepository;


@RestController
@RequestMapping()
public class SeriesController {
	@Autowired
	SeriesRepository repository;
	public SeriesRepository getRepository() {
        return repository;
    }
 
    public void setRepository(SeriesRepository repository) {
        this.repository = repository;
    }
	// expose "/series" and return list of series
	@GetMapping("/series")
	  
	public ResponseEntity<List<Series>> getAllSeries() {
        return ResponseEntity.ok(repository.findAll());
    }
	// add mapping for GET /series/id/{id}
	
		@GetMapping("/series/id/{id}")
		ResponseEntity<Series> getSeriesById(@PathVariable Long id) {
	        return ResponseEntity.ok(repository.findById(id).get());
	    }
    // add mapping for GET /series/name/{name}
		@GetMapping("/series/name/{name}")
		ResponseEntity<Series> getSeriesByName(@PathVariable String name) {
	        return ResponseEntity.ok(repository.findByName(name));
	    }
	// add mapping for POST /addSeries - add new series
		
		@PostMapping(value = "/addSeries",consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
		public ResponseEntity<Object> createSeries(@RequestBody Series series) {
			Series savedSeries = repository.save(series);

			//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedSeries.getId()).toUri();

			return ResponseEntity.ok(savedSeries);

		}
		// add mapping for PUT /update - update existing series
		
		@PutMapping(value="/update",consumes={ MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
		public ResponseEntity<Object> updateSeries(@RequestBody Series series) {
			Series savedSeries = repository.save(series);

			//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					//.buildAndExpand(savedSeries.getId()).toUri();

			return ResponseEntity.ok(savedSeries);

		}
		// add mapping for DELETE /delete/{id} - delete series
		
		@DeleteMapping("/delete/{id}")
		ResponseEntity<String> deleteSeries(@PathVariable Long id) {
            repository.deleteById(id);
        return ResponseEntity.ok("Series Removed !"+ id);
    }
		


	
}
