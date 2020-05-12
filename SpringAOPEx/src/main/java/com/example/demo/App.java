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
	
		
		//customer.addCustomerAround(1,"Mily");
		//System.out.println("///////////////////////////////////");
		Customer cust=new Customer(1,"Mily");
		customer.addCustomer(cust);
	    System.out.println(customer.addCustomerReturnValue());
	    try {
		customer.addCustomerThrowException();
	     } catch (Exception e) {
		  e.printStackTrace();
	}   
	    cust=new Customer(2,"Mily123");
	    customer.addCustomer(cust);
		//customer.getCustomer(1);
         System.out.println(customer.findByCustomerId(cust.getCustId()));
         System.out.println(customer.findByCustomerIdReturnValue());
      
    }
}
