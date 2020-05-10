package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext appContext = new ClassPathXmlApplicationContext("Spring-Customer.xml");

    	CustomerBo customer = (CustomerBo) appContext.getBean("customerBo");
    	//customer.addCustomer();
    	    	
		//customer.addCustomerReturnValue();
		
		//try {
			//customer.addCustomerThrowException();
		//} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		
		customer.addCustomerAround(1,"Mily");
		System.out.println("///////////////////////////////////");
		
		customer.addCustomerAround(2,"Mily123");
		
		System.out.println("///////////getCustomer////////////");
		
		customer.getCustomer(1);
    }
}
