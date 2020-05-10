package com.example.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("bean.xml");
				
		// retrieve bean from spring container
		MyBean theBean = context.getBean("upiPayment", MyBean.class);
		
		// call methods on the bean
		System.out.println(theBean.getDailyPayment());
		
		System.out.println(theBean.getDailyService());
		
		// close the context
		context.close();
	}

}







