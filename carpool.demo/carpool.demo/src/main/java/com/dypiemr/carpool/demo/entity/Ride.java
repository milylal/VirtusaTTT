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
	@Column(name="driver")
	private String driver;
	@Column(name="vehicleNo")
	private String vehicleNo;
	@Column(name="phoneNo")
	private int phoneNo;
	@Column(name="rdate")
	private String rdate;
	@Column(name="rtime")
	private String rtime;
	@Column(name="start_loc")
	private String start_loc;
	@Column(name="end_loc")
	private String end_loc;
	@Column(name="vacancy")
	private int vacancy;
	@Column(name="base_fare")
	private int base_fare;
	// define constructors
	
public Ride() {
		
	}
	
	public Ride(int id, String driver, String vehicleNo, int phoneNo, String rdate, String rtime, String start_loc,
		String end_loc, int vacancy, int base_fare) {

	this.id = id;
	this.driver = driver;
	this.vehicleNo = vehicleNo;
	this.phoneNo = phoneNo;
	this.rdate = rdate;
	this.rtime = rtime;
	this.start_loc = start_loc;
	this.end_loc = end_loc;
	this.vacancy = vacancy;
	this.base_fare = base_fare;
    }

	// define getter/setter  

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getRtime() {
		return rtime;
	}

	public void setRtime(String rtime) {
		this.rtime = rtime;
	}

	public String getStart_loc() {
		return start_loc;
	}

	public void setStart_loc(String start_loc) {
		this.start_loc = start_loc;
	}

	public String getEnd_loc() {
		return end_loc;
	}

	public void setEnd_loc(String end_loc) {
		this.end_loc = end_loc;
	}

	public int getVacancy() {
		return vacancy;
	}

	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}

	public int getBase_fare() {
		return base_fare;
	}

	public void setBase_fare(int base_fare) {
		this.base_fare = base_fare;
	}
	// define tostring

	@Override
	public String toString() {
		return "Ride [id=" + id + ", driver=" + driver + ", vehicleNo=" + vehicleNo + ", phoneNo=" + phoneNo
				+ ", rdate=" + rdate + ", rtime=" + rtime + ", start_loc=" + start_loc + ", end_loc=" + end_loc
				+ ", vacancy=" + vacancy + ", base_fare=" + base_fare + "]";
	}

		
	
	}