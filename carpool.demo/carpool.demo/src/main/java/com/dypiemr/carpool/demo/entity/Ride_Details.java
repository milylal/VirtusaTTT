package com.dypiemr.carpool.demo.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ride_details")
public class Ride_Details {
 
    @EmbeddedId
	private Customer_Rides_PK pkey;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customerId",referencedColumnName = "Id", insertable=false, updatable=false)
	private Customer customer;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="rideId",referencedColumnName = "Id", insertable=false, updatable=false)
	private Ride ride;
	@Column
	private int riderNo;
	
	public Customer_Rides_PK getPkey() {
		return pkey;
	}

	public void setPkey(Customer_Rides_PK pkey) {
		this.pkey = pkey;
	}
   
	public int getRiderNo() {
		return riderNo;
	}
	public void setRiderNo(int riderNo) {
		this.riderNo = riderNo;
	}

	public Customer getUserId() {
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
    
}
