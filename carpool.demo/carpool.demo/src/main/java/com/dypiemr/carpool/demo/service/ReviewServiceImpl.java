package com.dypiemr.carpool.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dypiemr.carpool.demo.dao.ReviewDAO;
import com.dypiemr.carpool.demo.entity.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

   private ReviewDAO reviewDAO;
	
	@Autowired
	public ReviewServiceImpl(ReviewDAO thereviewDAO) {
		reviewDAO = thereviewDAO;
	}
	@Override
	@Transactional
	public void save(Review review) {
		// TODO Auto-generated method stub
		reviewDAO.save(review);
		
		
	}

	@Override
	@Transactional
	public void delete(int reviewId) {
		// TODO Auto-generated method stub
		reviewDAO.delete(reviewId);
		
	}

	@Override
	@Transactional
	public Review findByReviewId(int reviewId) {
		// TODO Auto-generated method stub
		return reviewDAO.findByReviewId(reviewId);
	}
	@Override
	@Transactional
	public List<Review> findAll() {
		// TODO Auto-generated method stub
		return reviewDAO.findAll();
	}

}
