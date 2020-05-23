package com.dypiemr.carpool.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ride")
public class Ride {
	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="rdate")
	private String rideDate;
	@Column(name="rtime")
	private String rideTime;
	@Column(name="start_loc")
	private String rideStartLocation;
	@Column(name="end_loc")
	private String rideEndLocation;
	@Column(name="vacancy")
	private int vacancy;
	@Column(name="base_fare")
	private int baseFare;
	// define constructors
	
public Ride() {
		
	}

	public Ride(String rideDate, String rideTime, String rideStartLocation,String rideEndLocation,int vacancy,int baseFare) {
		this.rideDate = rideDate;
		this.rideTime = rideTime;
		this.rideStartLocation=rideStartLocation;
		this.rideEndLocation=rideEndLocation;
		this.baseFare=baseFare;
		this.vacancy = vacancy;
	}
	
	// define getter/setter
	
	public int getId() {
			return id;
		}

	public void setId(int id) {
			this.id = id;
		}
	public String getRideDate() {
		return rideDate;
	}
	public int getBaseFare() {
		return baseFare;
	}
	public void setBaseFare(int BaseFare) {
		this.baseFare = baseFare;
	}
	public void setRideDate(String rideDate) {
		this.rideDate = rideDate;
	}
	public String getRideTime() {
		return rideTime;
	}
	public void setRideTime(String rideTime) {
		this.rideTime = rideTime;
	}
	public String getRideStartLocation() {
		return rideStartLocation;
	}
	public void setRideStartLocation(String rideStartLocation) {
		this.rideStartLocation = rideStartLocation;
	}
	public String getRideEndLocation() {
		return rideEndLocation;
	}
	public void setRideEndLocation(String rideEndLocation) {
		this.rideEndLocation = rideEndLocation;
	}
	public int getVacancy() {
		return vacancy;
	}
	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}
	// define tostring

	@Override
	public String toString() {
		return "Ride [id=" + id + ", rideDate=" + rideDate + ", rideTime=" + rideTime + ", rideStartLocation="
				+ rideStartLocation + ", rideEndLocation=" + rideEndLocation + ", vacancy=" + vacancy + ", baseFare="
				+ baseFare + "]";
	}

	
	
	
}
