package com.dypiemr.carpool.demo.dao;


import java.util.List;

import com.dypiemr.carpool.demo.entity.Customer;

public interface CustomerDAO {
	public List<Customer> findAll();
    public Customer findById(int theId);
	public void save(Customer theCustomer);
	public void deleteById(int theId);
}
