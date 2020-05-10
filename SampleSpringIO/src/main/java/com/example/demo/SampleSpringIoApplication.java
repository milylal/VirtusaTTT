package com.example.demo;

public class SampleSpringIoApplication {

		public static void main(String[] args) {

			// create the object
			Api theApi = new UPIPayment();
			
			// use the object
			System.out.println(theApi.getDailyPayment());	
			//System.out.println(theApi.getDailyService());
		}

	


}
