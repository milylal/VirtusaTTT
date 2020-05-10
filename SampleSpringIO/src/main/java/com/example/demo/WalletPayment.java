package com.example.demo;

public class WalletPayment implements Api {

	// define a private field for the dependency
	private HappyPaymentService paymentService;
	
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
}








