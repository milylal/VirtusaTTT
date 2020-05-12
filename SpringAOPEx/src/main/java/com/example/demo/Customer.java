package com.example.demo;

public class Customer {
	int custId;
	String name;
	int age;
	public Customer() {
		
	}
	public Customer(int id, String name) {
		// TODO Auto-generated constructor stub
		this.custId = id;
		this.name=name;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getName(int id) {
		return name;
	}
	public String getName1() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Customer : custId=" + custId + ", name=" + name+ "has";
	}
}
	
