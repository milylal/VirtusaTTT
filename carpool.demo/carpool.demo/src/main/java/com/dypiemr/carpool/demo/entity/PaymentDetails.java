package com.dypiemr.carpool.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "paymentdetails")
public class PaymentDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customerId",referencedColumnName = "id", insertable=false, updatable=false)
    private Customer customer;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="rideId",referencedColumnName = "id", insertable=false, updatable=false)
	private Ride ride;
	@Column(name="amount")
	private int amount;
	private int customerId;
	private int rideId;
	public int getUserId() {
		return customerId;
	}
	public void setUserId(int customerId) {
		this.customerId = customerId;
	}
	public int getRideId() {
		return rideId;
	}
	public void setRideId(int rideId) {
		this.rideId = rideId;
	}	
	public Customer getUser() {
		return customer;
	}

	public void setUser(Customer customer) {
		this.customer = customer;
	}

	public Ride getRide() {
		return ride;
	}

	public void setRide(Ride ride) {
		this.ride = ride;
	}
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPaymentId() {
		return id;
	}
	public void setPaymentId(int paymentId) {
		this.id = paymentId;
	}
}
