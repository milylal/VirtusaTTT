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
@Table(name="review")
public class Review 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@JoinColumn(name="customerId",referencedColumnName = "id",insertable=false, updatable=false)
	@ManyToOne(cascade=CascadeType.ALL)
	private Customer customer;
	
	@JoinColumn(name="rideId",referencedColumnName = "id",insertable=false, updatable=false)
	@ManyToOne(cascade=CascadeType.ALL)
	private Ride ride;
	
	@Column(name="comments")
	private String comments;
	@Column(name="stars")
	private int stars;
	
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
	public int getReviewId() {
		return id;
	}
	public void setReviewId(int reviewId) {
		this.id = reviewId;
	}
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", customer=" + customer + ", ride=" + ride + ", comments=" + comments + ", stars="
				+ stars + "]";
	}
	

}
