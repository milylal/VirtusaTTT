package com.dypiemr.ecommerce.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dypiemr.ecommerce.model.*;

public interface EcommerceRepository extends JpaRepository<EcommerceModel, Long>{
	public List<EcommerceModel> findAll();
    public EcommerceModel findById(int theId);
    public EcommerceModel findByType(String theName);
	public EcommerceModel save(EcommerceModel theSeries);
	public void deleteById(int theId);
}