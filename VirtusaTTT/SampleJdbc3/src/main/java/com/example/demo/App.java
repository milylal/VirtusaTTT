package com.example.demo;

import java.util.Scanner;

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
    	ApplicationContext context = 
            new ClassPathXmlApplicationContext("Spring-Module.xml");
        	 
            CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
            Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
            System.out.println("Enter id ---");
            int a= sc.nextInt();
            System.out.println("Enter name ---");
            String n= sc.nextLine();
            Customer customer = new Customer(a,n);
            customerDAO.insert(customer);
        	
            Customer customer1 = customerDAO.findByCustomerId(a);
            System.out.println(customer1);
         // call methods on the bean
    		System.out.println(customerDAO.getDailyPayment());
    		
    		System.out.println(customerDAO.getDailyService());
    }
}
