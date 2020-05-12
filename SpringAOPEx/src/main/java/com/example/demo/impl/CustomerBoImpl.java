package com.example.demo.impl;

import com.example.demo.Customer;
import com.example.demo.CustomerBo;

public class CustomerBoImpl implements CustomerBo {
	Customer cust=new Customer();
	public String findByCustomerIdReturnValue(){
		System.out.println("addCustomerReturnValue() is running <<");
		return "done";
	}
	
	public void findByCustomerIdThrowException() throws Exception {
		System.out.println("addCustomerThrowException() is running <<");
		throw new Exception("Generic Error");
	}

	@Override
	public String addCustomerReturnValue(){
		System.out.println("addCustomerReturnValue() is running <<");
		return "done";
	}
	
	public void addCustomerThrowException() throws Exception {
		System.out.println("addCustomerThrowException() is running <<");
		throw new Exception("Generic Error");
	}
	
	public void addCustomerAround(Customer c){
		System.out.println("addCustomerAround() is running, args : "+c.getCustId()+"<<"+c.getName1());
	}
	public void addCustomer(Customer c){
		System.out.println("addCustomerAround() is running, args : " +c.getCustId()+"<<"+c.getName1());
		cust=c;
	}
	public  Customer findByCustomerId(int custId) {
		System.out.println("findByCustomerId is running, args : "+cust.getName(custId));
        return cust;
	}

}
