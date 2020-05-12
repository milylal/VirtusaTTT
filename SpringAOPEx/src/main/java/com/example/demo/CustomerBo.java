package com.example.demo;

public interface CustomerBo {
	//void addCustomer();
	
	 String addCustomerReturnValue();
	 String findByCustomerIdReturnValue();
	  void addCustomerThrowException() throws Exception;
	  void addCustomerAround(Customer customer);
	  void addCustomer(Customer customer) ;
	  Customer findByCustomerId(int custId) ;
	//String getCustomer(int id);
}
