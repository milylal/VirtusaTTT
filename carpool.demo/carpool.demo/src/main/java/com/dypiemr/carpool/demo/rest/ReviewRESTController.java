package com.dypiemr.carpool.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dypiemr.carpool.demo.entity.Review;
import com.dypiemr.carpool.demo.exception.NotFoundException;
import com.dypiemr.carpool.demo.service.ReviewService;

@RestController
@RequestMapping("/api")
public class ReviewRESTController {
	
	private ReviewService reviewService;
	
	@Autowired
	public ReviewRESTController(ReviewService theReviewService) {
		reviewService = theReviewService;
	}
	
	@GetMapping("/review")
	public List<Review> findAll() {
		return reviewService.findAll();
	}
	@GetMapping("/createReview")
	public Review createReview(@RequestParam("rideId") int rideId,@RequestParam("stars") int stars,@RequestParam("comments") String comments)  {
		Review review = new Review();
		review.setRideId(rideId);
		review.setUserId(2);
		review.setStars(stars);
		review.setComments(comments);
		reviewService.save(review);
		return review;
	}
	@GetMapping("/getReview")
	public Review getReview(@RequestParam("reviewId") int reviewId) {
		Review theReview= reviewService.findByReviewId(reviewId);
		if (theReview == null) {
			throw new NotFoundException("Review not found with id " + reviewId);
		}
		
		return theReview;
	}

}
