package com.dypiemr.webseries.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dypiemr.webseries.model.*;

public interface SeriesRepository extends JpaRepository<Series, Long>{
	public List<Series> findAll();
    public Series findById(int theId);
	public Series findByName(String theName);
	public Series save(Series theSeries);
	public void deleteById(int theId);
}