package com.dypiemr.carpool.demo.service;
import java.util.List;
import com.dypiemr.carpool.demo.entity.*;

public interface CustomerService {
    public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer theCustomer);
	
	public void deleteById(int theId);


}
