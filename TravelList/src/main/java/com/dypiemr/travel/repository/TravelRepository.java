package com.dypiemr.travel.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dypiemr.travel.model.*;

public interface TravelRepository extends JpaRepository<Travel, Long>{
	public List<Travel> findAll();
    public Travel findById(int theId);
	public Travel save(Travel theSeries);
	public void deleteById(int theId);
}