package com.dypiemr.carrental.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dypiemr.carrental.model.*;

public interface RentalRepository extends JpaRepository<RentalModel, Long>{
	public List<RentalModel> findAll();
    public RentalModel findById(int theId);
	public RentalModel save(RentalModel theSeries);
	public void deleteById(int theId);
}