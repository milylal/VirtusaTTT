package com.dypiemr.carpool.demo.dao;


import java.util.List;

import com.dypiemr.carpool.demo.entity.Review;

public interface ReviewDAO {
	public List<Review> findAll();
	void save(Review review);
	void delete(int reviewId);
	Review findByReviewId(int reviewId);
}
