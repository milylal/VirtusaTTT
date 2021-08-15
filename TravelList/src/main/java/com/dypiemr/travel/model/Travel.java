package com.dypiemr.travel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="travel")
public class Travel {

	// define fields
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	@Column(name="name")
	private String name;

	@Column(name="description")
	private String description;
	
		
	// define constructors
	
	public Travel() {
		
	}

	
	public Travel(String name, String description) {
		this.name = name;
		this.description = description;
	}


	// define getter/setter

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Travel [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
		
}

