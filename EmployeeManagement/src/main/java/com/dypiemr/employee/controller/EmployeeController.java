package com.dypiemr.employee.controller;

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

import com.dypiemr.employee.model.EmployeeModel;
import com.dypiemr.employee.repository.EmployeeRepository;


@RestController
@RequestMapping()
public class EmployeeController {
	@Autowired
	EmployeeRepository repository;
	public EmployeeRepository getRepository() {
        return repository;
    }
 
    public void setRepository(EmployeeRepository repository) {
        this.repository = repository;
    }
	// expose "/getAllEmployee" and return list of employees
	@GetMapping("/getAllEmployee")
	  
	public ResponseEntity<List<EmployeeModel>> getAllEmployee() {
        return ResponseEntity.ok(repository.findAll());
    }
	// add mapping for GET /getEmployee?id=<employeeId>
	
		@GetMapping("/getEmployee")
		public ResponseEntity<EmployeeModel> getEmployeeById(@RequestParam(value="id") Long employeeId) {
			Optional <EmployeeModel> employeeResponse =  repository.findById(employeeId);

	        return ResponseEntity.ok(employeeResponse.get());
	    }
    
	// add mapping for POST /saveBook- add new book
		
		@PostMapping(value = "/saveEmployee",consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
		public ResponseEntity<Object> createEmployee(@RequestBody EmployeeModel employee) {
			EmployeeModel savedEmployee = repository.save(employee);

			//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedRental.getId()).toUri();

			return ResponseEntity.ok(savedEmployee);

		}
		// add mapping for PUT /editBook?id=<bookId> - update existing books
		
		@PutMapping(value="/editEmployee",consumes={ MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
		public ResponseEntity<Object> editEmployee(@RequestParam(value="id") long employeeId, @RequestBody EmployeeModel employee) {
			Optional <EmployeeModel> employeeResponse =  repository.findById(employeeId);
			if (employeeResponse.isPresent()){
				EmployeeModel existingEmployee = employeeResponse.get();
				existingEmployee.setEmployeeName(existingEmployee.getEmployeeName());
				existingEmployee.setEmployeeEmail(existingEmployee.getEmployeeEmail());
				existingEmployee.setDept(existingEmployee.getDept());
				EmployeeModel savedEmployee = repository.save(employee);

			//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					//.buildAndExpand(savedRentals.getId()).toUri();

			return ResponseEntity.ok(savedEmployee); }
			else {
				return ResponseEntity.notFound().build();
			}

		}
		// add mapping for DELETE /deleteEmployee?id=<carId> - delete employee
		
		@DeleteMapping("/deleteEmployee")
		public ResponseEntity<Long> deleteEmployee(@RequestParam(value="id") long employeeId) {
            repository.deleteById(employeeId);
        return ResponseEntity.ok(employeeId);
    }
		


	
}

