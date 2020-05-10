package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpiPayment implements MyBean {

	private HappyPaymentService paymentService;

	public UpiPayment() {
		
	}
	@Autowired
	public UpiPayment(HappyPaymentService paymentService) {
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










