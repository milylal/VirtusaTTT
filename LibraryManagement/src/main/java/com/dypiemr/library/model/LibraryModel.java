package com.dypiemr.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="library")
public class LibraryModel {

	// define fields
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bookId")
	private long id;
	@Column(name="quantity")
	private String quantity;

	@Column(name="bookName")
	private String bookName;
	
	@Column(name="genre")
	private String genre;
	
	// define constructors
	
	public LibraryModel() {
		
	}

	public LibraryModel(String quantity, String bookName, String genre) {
		this.quantity = quantity;
		this.bookName = bookName;
		this.genre = genre;
	}


	// define getter/setter

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "LibraryModel [bookId=" + id + ", quantity=" + quantity + ", bookName=" + bookName + ", genre=" + genre
				+ "]";
	}
	
		
}

