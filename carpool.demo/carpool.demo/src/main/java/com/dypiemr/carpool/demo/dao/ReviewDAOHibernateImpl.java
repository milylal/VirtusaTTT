package com.dypiemr.carpool.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.dypiemr.carpool.demo.entity.Review;
import com.dypiemr.carpool.demo.entity.Ride;
@Repository
public class ReviewDAOHibernateImpl implements ReviewDAO {
	// define field for entitymanager	
			private EntityManager entityManager;
				
			// set up constructor injection
			@Autowired
			public ReviewDAOHibernateImpl(EntityManager theEntityManager) {
				entityManager = theEntityManager;
			}
			
			
	@Override
	public void save(Review review) {
		// TODO Auto-generated method stub
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save review
		currentSession.saveOrUpdate(review);
		
	}

	@Override
	public void delete(int reviewId) {
		// TODO Auto-generated method stub
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Review where id=:reviewId");
		theQuery.setParameter("reviewId", reviewId);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public Review findByReviewId(int reviewId) {
		// TODO Auto-generated method stub
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the review
		Review theReview =currentSession.get(Review.class, reviewId);
		
		// return the review
		return theReview;
	}


	@Override
	public List<Review> findAll() {
		// TODO Auto-generated method stub
		// get the current hibernate session
					Session currentSession = entityManager.unwrap(Session.class);
					
					// create a query
					Query<Review> theQuery =currentSession.createQuery("from Review", Review.class);
					// execute query and get result list
					List<Review> review = theQuery.getResultList();
					
					// return the results		
					return review;
	}
}
