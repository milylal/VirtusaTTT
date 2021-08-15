package com.dypiemr.library.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dypiemr.library.model.*;

public interface LibraryRepository extends JpaRepository<LibraryModel, Long>{
	public List<LibraryModel> findAll();
    public LibraryModel findById(int theId);
	public LibraryModel findByGenre(String theName);
	public LibraryModel save(LibraryModel theSeries);
	public void deleteById(int theId);
}