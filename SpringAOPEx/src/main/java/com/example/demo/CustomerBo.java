package com.example.demo;

public interface CustomerBo {
	void addCustomer();
	
	String addCustomerReturnValue();
	
	void addCustomerThrowException() throws Exception;
	
	void addCustomerAround(int id,String name);
	
	String getCustomer(int id);
}
