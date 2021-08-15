package com.dypiemr.carrental.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rental")
public class RentalModel {

	// define fields
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="carId")
	private long id;
	@Column(name="carModel")
	private String carModel;

	@Column(name="carNo")
	private String carNo;
	
	@Column(name="status")
	private String status;
	
	// define constructors
	
	public RentalModel() {
		
	}

	public RentalModel(String carModel, String carNo, String status) {
		this.carModel = carModel;
		this.carNo = carNo;
		this.status = status;
	}

	// define getter/setter
	
	public long getCarId() {
		return id;
	}

	public void setCarId(long carId) {
		this.id = carId;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	// define tostring
	@Override
	public String toString() {
		return "RentalModel [carId=" + id+ ", carModel=" + carModel + ", carNo=" + carNo + ", status" + status + "]";
	}
	
		
}

