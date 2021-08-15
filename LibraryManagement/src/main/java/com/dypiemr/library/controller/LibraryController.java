package com.dypiemr.library.controller;

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


import com.dypiemr.library.model.LibraryModel;
import com.dypiemr.library.repository.LibraryRepository;


@RestController
@RequestMapping()
public class LibraryController {
	@Autowired
	LibraryRepository repository;
	public LibraryRepository getRepository() {
        return repository;
    }
 
    public void setRepository(LibraryRepository repository) {
        this.repository = repository;
    }
	// expose "/getBooks" and return list of books
	@GetMapping("/getBooks")
	  
	public ResponseEntity<List<LibraryModel>> getAllBooks() {
        return ResponseEntity.ok(repository.findAll());
    }
	// add mapping for GET /getByType?id=<genre>
	
		@GetMapping("/getByType")
		ResponseEntity<LibraryModel> getCarById(@RequestParam(value="genre") String genre) {
			LibraryModel libraryResponse =  repository.findByGenre(genre);

	        return ResponseEntity.ok(libraryResponse);
	    }
    
	// add mapping for POST /saveBook- add new book
		
		@PostMapping(value = "/saveBook",consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
		public ResponseEntity<Object> createLibrary(@RequestBody LibraryModel books) {
			LibraryModel savedBooks = repository.save(books);

			//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedRental.getId()).toUri();

			return ResponseEntity.ok(savedBooks);

		}
		// add mapping for PUT /editBook?id=<bookId> - update existing books
		
		@PutMapping(value="/editBook",consumes={ MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
		public ResponseEntity<Object> editRentals(@RequestParam(value="id") long bookId, @RequestBody LibraryModel book) {
			Optional <LibraryModel> libraryResponse =  repository.findById(bookId);
			if (libraryResponse.isPresent()){
				LibraryModel existingBook = libraryResponse.get();
				existingBook.setBookName(existingBook.getBookName());
				existingBook.setGenre(existingBook.getGenre());
				existingBook.setQuantity(existingBook.getQuantity());
				LibraryModel savedBooks = repository.save(book);

			//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					//.buildAndExpand(savedRentals.getId()).toUri();

			return ResponseEntity.ok(savedBooks); }
			else {
				return ResponseEntity.notFound().build();
			}

		}
		// add mapping for DELETE /deleteCar?id=<carId> - delete retals
		
		@DeleteMapping("/deleteBook")
		ResponseEntity<Long> deleteBook(@RequestParam(value="id") long bookId) {
            repository.deleteById(bookId);
        return ResponseEntity.ok(bookId);
    }
		


	
}

