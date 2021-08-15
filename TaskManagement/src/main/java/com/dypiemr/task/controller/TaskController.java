package com.dypiemr.task.controller;

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

import com.dypiemr.task.model.TaskModel;
import com.dypiemr.task.repository.TaskRepository;


@RestController
@RequestMapping()
public class TaskController {
	@Autowired
	TaskRepository repository;
	public TaskRepository getRepository() {
        return repository;
    }
 
    public void setRepository(TaskRepository repository) {
        this.repository = repository;
    }
	@GetMapping("/alltasks")
	  
	public ResponseEntity<List<TaskModel>> getAllTasks() {
        return ResponseEntity.ok(repository.findAll());
    }
	
		@GetMapping("/getTask")
		public ResponseEntity<TaskModel> getEmployeeById(@RequestParam(value="taskHolderName") String taskHolderName) {
		TaskModel employeeResponse =  repository.findByTaskHolderName(taskHolderName);

	        return ResponseEntity.ok(employeeResponse);
	    }
    
		
		@PostMapping(value = "/saveTask",consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
		public ResponseEntity<Object> changeStatus(@RequestBody TaskModel task) {
			TaskModel savedTask = repository.save(task);

			//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedRental.getId()).toUri();

			return ResponseEntity.ok(savedTask);

		}
		
		
		@PutMapping(value="/changeStatus",consumes={ MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
		public ResponseEntity<Object> editStatus(@RequestParam(value="id") long taskId, @RequestBody TaskModel task) {
			Optional <TaskModel> taskResponse =  repository.findById(taskId);
			if (taskResponse.isPresent()){
				TaskModel existingTask =taskResponse.get();
				existingTask.setTaskDate(existingTask.getTaskDate());
				existingTask.setTaskHolderName(existingTask.getTaskHolderName());
				existingTask.setTaskName(existingTask.getTaskName());
				existingTask.setTaskStatus(existingTask.getTaskStatus());
				TaskModel savedTask = repository.save(task);

			//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					//.buildAndExpand(savedRentals.getId()).toUri();

			return ResponseEntity.ok(savedTask); }
			else {
				return ResponseEntity.notFound().build();
			}

		}
		// add mapping for DELETE /deleteEmployee?id=<carId> - delete employee
		
		@DeleteMapping("/deleteTask")
		public ResponseEntity<Long> deleteEmployee(@RequestParam(value="id") long taskId) {
            repository.deleteById(taskId);
        return ResponseEntity.ok(taskId);
    }
		


	
}

