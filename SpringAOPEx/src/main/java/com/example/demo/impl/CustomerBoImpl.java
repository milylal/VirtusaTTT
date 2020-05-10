package com.example.demo.impl;

import com.example.demo.CustomerBo;

public class CustomerBoImpl implements CustomerBo {
	public void addCustomer(){
		System.out.println("addCustomer() is running <<");
	}
	
	public String getCustomerReturnValue(){
		System.out.println("addCustomerReturnValue() is running <<");
		return "done";
	}
	
	public void getCustomerThrowException() throws Exception {
		System.out.println("addCustomerThrowException() is running <<");
		throw new Exception("Generic Error");
	}
	
	public void getCustomerAround(int id ,String name){
		System.out.println("addCustomerAround() is running, args : " + name + "<<");
	}

	@Override
	public String getCustomer(int id) {
		// TODO Auto-generated method stub
		System.out.println("getCustomer() is running <<");
		return "Mily";
	}
	public String addCustomerReturnValue(){
		System.out.println("addCustomerReturnValue() is running <<");
		return "done";
	}
	
	public void addCustomerThrowException() throws Exception {
		System.out.println("addCustomerThrowException() is running <<");
		throw new Exception("Generic Error");
	}
	
	public void addCustomerAround(int id ,String name){
		System.out.println("addCustomerAround() is running, args : " + name + "<<");
	}
}
