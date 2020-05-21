package com.dypiemr.carpool.demo.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dypiemr.carpool.demo.entity.Customer_Rides_PK;
import com.dypiemr.carpool.demo.entity.Ride;
import com.dypiemr.carpool.demo.entity.Ride_Details;

@Repository
public class RideDAOHibernateImpl implements RideDAO {
	// define field for entitymanager	
		private EntityManager entityManager;
			
		// set up constructor injection
		@Autowired
		public RideDAOHibernateImpl(EntityManager theEntityManager) {
			entityManager = theEntityManager;
		}
		
		
		public List<Ride> findAll() {

			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			
			// create a query
			Query<Ride> theQuery =
					currentSession.createQuery("from Ride", Ride.class);
			
			// execute query and get result list
			List<Ride> ride = theQuery.getResultList();
			
			// return the results		
			return ride;
		}
			@Override
			public Ride findById(int theId) {

				// get the current hibernate session
				Session currentSession = entityManager.unwrap(Session.class);
				
				// get the ride
				Ride theRide =
						currentSession.get(Ride.class, theId);
				
				// return the ride
				return theRide;
			}


			@Override
			public void save(Ride theRide) {

				// get the current hibernate session
				Session currentSession = entityManager.unwrap(Session.class);
				
				// save ride
				currentSession.saveOrUpdate(theRide);
			}


			@Override
			public void deleteById(int theId) {
				
				// get the current hibernate session
				Session currentSession = entityManager.unwrap(Session.class);
						
				// delete object with primary key
				Query theQuery = 
						currentSession.createQuery(
								"delete from Ride where id=:rideId");
				theQuery.setParameter("rideId", theId);
				
				theQuery.executeUpdate();
			}


			@Override
			public void saveRider(int rideId, int customerId) {
				// TODO Auto-generated method stub
				// get the current hibernate session
				Session currentSession = entityManager.unwrap(Session.class);
				Query theQuery = 
						currentSession.createQuery("from Ride_Details where rideId=:rideId", Ride_Details.class);
				int rideno=theQuery.getFirstResult();
				Ride_Details userRide = new Ride_Details();
				Customer_Rides_PK userRidePk = new Customer_Rides_PK();
				userRidePk.setRideId(rideId);
				userRidePk.setUserId(customerId);
				userRide.setPkey(userRidePk);
				userRide.setRiderNo(rideno+1);
				currentSession.save(userRide);
				
			}


			@Override
			public int countRides() {
				// TODO Auto-generated method stub
				Session currentSession = entityManager.unwrap(Session.class);
				Query theQuery = currentSession.createQuery("from Ride", Ride.class);
				return theQuery.getResultList().size();
			}

			
}
