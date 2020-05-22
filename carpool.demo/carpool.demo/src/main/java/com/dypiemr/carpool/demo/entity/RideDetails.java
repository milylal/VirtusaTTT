package com.dypiemr.carpool.demo.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ridedetails")
public class RideDetails {
 
    @EmbeddedId
	private Customer_Rides_PK pkey;
    @Column(name="riderNo")
	private int riderNo;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customerId",referencedColumnName = "id", insertable=false, updatable=false)
	private Customer customer;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="rideId",referencedColumnName = "id", insertable=false, updatable=false)
	private Ride ride;
	
	
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
