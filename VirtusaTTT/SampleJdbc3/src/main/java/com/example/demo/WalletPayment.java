package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WalletPayment implements CustomerDAO {

	// define a private field for the dependency
	private HappyPaymentService paymentService;
	@Autowired
	// define a constructor for dependency injection
	public WalletPayment(HappyPaymentService thePaymentService) {
		paymentService = thePaymentService;
	}
	
	@Override
	public String getDailyPayment() {
		return "Spend 30 rs";
	}

	@Override
	public String getDailyService() {		
				
		return paymentService.getService();
	}


	@Override
	public void insert(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer findByCustomerId(int custId) {
		// TODO Auto-generated method stub
		return null;
	}
}








