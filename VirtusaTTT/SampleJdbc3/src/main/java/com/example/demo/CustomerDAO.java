package com.example.demo;

public interface CustomerDAO {
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
    public String getDailyPayment();
	public String getDailyService();
}
