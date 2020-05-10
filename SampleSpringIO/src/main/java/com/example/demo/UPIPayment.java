package com.example.demo;

public class UPIPayment implements Api {

	private HappyPaymentService paymentService;

	public UPIPayment() {
		
	}
	
	public UPIPayment(HappyPaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@Override
	public String getDailyPayment() {
		return "Paid 50Rs";
	}

	@Override
	public String getDailyService() {
		return "Through UPIPayment " + paymentService.getService();
	}
	// add an init method
		public void doMyStartupStuff() {
			System.out.println("UPI Payment: inside method doMyStartupStuff");
		}
		
		// add a destroy method
		public void doMyCleanupStuffYoYo() {
			System.out.println("UPI Payment: inside method doMyCleanupStuff");		
		}

}










