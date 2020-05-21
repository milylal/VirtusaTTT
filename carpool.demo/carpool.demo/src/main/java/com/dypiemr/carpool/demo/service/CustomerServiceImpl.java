package com.dypiemr.carpool.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dypiemr.carpool.demo.dao.CustomerDAO;
import com.dypiemr.carpool.demo.entity.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDAO;
	
	@Autowired
	public CustomerServiceImpl(CustomerDAO theCustomerDAO) {
		customerDAO = theCustomerDAO;
	}
	
	@Override
	@Transactional
	public List<Customer> findAll() {
		return customerDAO.findAll();
	}

	@Override
	@Transactional
	public Customer findById(int theId) {
		return customerDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Customer theCustomer) {
		customerDAO.save(theCustomer);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		customerDAO.deleteById(theId);
	}

}


