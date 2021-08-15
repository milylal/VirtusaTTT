package com.dypiemr.ecommerce.controller;

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

import com.dypiemr.ecommerce.model.EcommerceModel;
import com.dypiemr.ecommerce.repository.EcommerceRepository;


@RestController
@RequestMapping()
public class EcommerceController {
	@Autowired
	EcommerceRepository repository;
	public EcommerceRepository getRepository() {
        return repository;
    }
 
    public void setRepository(EcommerceRepository repository) {
        this.repository = repository;
    }
	@GetMapping("/getAllProduct")
	  
	public ResponseEntity<List<EcommerceModel>> getAllProduct() {
        return ResponseEntity.ok(repository.findAll());
    }
	
		@GetMapping("/getByType")
		public ResponseEntity<EcommerceModel> getProductByType(@RequestParam(value="type") String type) {
		EcommerceModel ecommerceResponse =  repository.findByType(type);

	        return ResponseEntity.ok(ecommerceResponse);
	    }
		@GetMapping("/getById")
		public ResponseEntity<EcommerceModel> getProductById(@RequestParam(value="id") Long productId) {
		Optional <EcommerceModel> ecommerceResponse =  repository.findById(productId);

	        return ResponseEntity.ok(ecommerceResponse.get());
	    }
    
		
		@PostMapping(value = "/saveProduct",consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
		public ResponseEntity<Object> changeStatus(@RequestBody EcommerceModel product) {
			EcommerceModel savedProduct = repository.save(product);

			//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedRental.getId()).toUri();

			return ResponseEntity.ok(savedProduct);

		}
		
		@DeleteMapping("/deleteProduct")
		public ResponseEntity<Long> deleteEmployee(@RequestParam(value="id") long productId) {
            repository.deleteById(productId);
        return ResponseEntity.ok(productId);
    }
		


	
}

