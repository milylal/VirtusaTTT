package com.example.demo.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	
	@Before("execution(* com.example.demo.CustomerBo.addCustomer(..))")
	public void logBefore(JoinPoint joinPoint) {

		System.out.println("logBefore() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}
	@Before("execution(* com.example.demo.CustomerBo.getCustomer(..))")
	public void logBefore1(JoinPoint joinPoint) {

		System.out.println("logBefore() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}
	
/*	@Before("execution(* com.virtusa.spring.collections.springcollections.CustomerBo.*(..))")
	public void logBefore2(JoinPoint joinPoint) {

		System.out.println(">logBefore() is running!");
		System.out.println(">hijacked : " + joinPoint.getSignature().getName());
		System.out.println(">******");
	}*/
	
	@After("execution(* com.example.demo.CustomerBo.addCustomer(..))")
	public void logAfter(JoinPoint joinPoint) {

		System.out.println("logAfter() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");

	}
	@After("execution(* com.example.demo.CustomerBo.getCustomer(..))")
	public void logAfter1(JoinPoint joinPoint) {

		System.out.println("logAfter() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");

	}
	@AfterReturning(
			pointcut = "execution(* com.example.demo.CustomerBo.addCustomerReturnValue(..))",
			returning= "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {

		System.out.println("logAfterReturning() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("Method returned value is : " + result);
		System.out.println("******");

	}
	@AfterReturning(
			pointcut = "execution(* com.example.demo.CustomerBo.getCustomerReturnValue(..))",
			returning= "result")
	public void logAfterReturning1(JoinPoint joinPoint, Object result) {

		System.out.println("logAfterReturning() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("Method returned value is : " + result);
		System.out.println("******");

	}
	
	@AfterThrowing(
			pointcut = "execution(* com.example.demo.CustomerBo.addCustomerThrowException(..))",
			throwing= "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

		System.out.println("logAfterThrowing() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("Exception : " + error);
		System.out.println("******");

	}
	@AfterThrowing(
			pointcut = "execution(* com.example.demo.CustomerBo.getCustomerThrowException(..))",
			throwing= "error")
	public void logAfterThrowing1(JoinPoint joinPoint, Throwable error) {

		System.out.println("logAfterThrowing() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("Exception : " + error);
		System.out.println("******");

	}
	
	@Around("execution(* com.example.demo.CustomerBo.addCustomerAround(..))")
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("logAround() is running!");
		System.out.println("hijacked method : " + joinPoint.getSignature().getName());
		
		System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
		
		System.out.println("Around before is running!");
		
		String val ="";
		
		
		
		for (int i=0;i<joinPoint.getArgs().length;i++) {
			System.out.println(joinPoint.getArgs()[i].toString());
			val = joinPoint.getArgs()[i].toString();
		}
		
		
		System.out.println(joinPoint.getArgs());
		
		if (val.equalsIgnoreCase("Mily")) {
			joinPoint.proceed();
		} else {
			doFallBackMethod(val);
		}
		
		
		System.out.println("Around after is running!");
		
		System.out.println("******");

	}
	
	/*private void doFallBackMethod1(String val) {
		System.out.println("==================Fallback method==" + val);
	}*/
	@Around("execution(* com.example.demo.CustomerBo.getCustomerAround(..))")
	public void logAround1(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("logAround() is running!");
		System.out.println("hijacked method : " + joinPoint.getSignature().getName());
		
		System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
		
		System.out.println("Around before is running!");
		
		String val ="";
		
		
		
		for (int i=0;i<joinPoint.getArgs().length;i++) {
			System.out.println(joinPoint.getArgs()[i].toString());
			val = joinPoint.getArgs()[i].toString();
		}
		
		
		System.out.println(joinPoint.getArgs());
		
		if (val.equalsIgnoreCase("Mily")) {
			joinPoint.proceed();
		} else {
			doFallBackMethod(val);
		}
		
		
		System.out.println("Around after is running!");
		
		System.out.println("******");

	}
	
	private void doFallBackMethod(String val) {
		System.out.println("==================Fallback method==" + val);
	}
}
