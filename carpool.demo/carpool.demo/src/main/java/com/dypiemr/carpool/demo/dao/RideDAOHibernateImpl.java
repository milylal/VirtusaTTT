package com.dypiemr.carpool.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dypiemr.carpool.demo.entity.CustomerRidesPk;
import com.dypiemr.carpool.demo.entity.PaymentDetails;
import com.dypiemr.carpool.demo.entity.Ride;
import com.dypiemr.carpool.demo.entity.RideDetails;

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
			public void saveRider(int rId, int customerId) {
				// TODO Auto-generated method stub
				// get the current hibernate session
				Session currentSession = entityManager.unwrap(Session.class);
				Query theQuery = currentSession.createQuery("select count(*) from RideDetails where ride_id=:rideId");
				theQuery.setParameter("rideId", rId);
				Long rdno = (Long)theQuery.uniqueResult();
				RideDetails userRide = new RideDetails();
				CustomerRidesPk userRidePk = new CustomerRidesPk();
				userRidePk.setRideId(rId);
				userRidePk.setUserId(customerId);
				userRide.setPkey(userRidePk);
				userRide.setRiderNo(rdno.intValue()+1);
				currentSession.save(userRide);
				
			}

			@Override
			public int countRides() {
				// TODO Auto-generated method stub
				Session currentSession = entityManager.unwrap(Session.class);
				Query theQuery = currentSession.createQuery("select count(*)from Ride");
				Long rdno = (Long)theQuery.uniqueResult();
				return rdno.intValue();
			}


			@Override
			public void payRide(int rId, int customerId) {
				// TODO Auto-generated method stub
				PaymentDetails pay=new PaymentDetails();
				Session currentSession = entityManager.unwrap(Session.class);
				Query theQuery = currentSession.createQuery("select baseFare from Ride where id=:rideId");
				theQuery.setParameter("rideId", rId);
				int rdfare = (int)theQuery.uniqueResult();
				pay.setRideId(rId);
				pay.setUserId(customerId);
				pay.setAmount(rdfare);
				System.out.println("Amount="+rdfare);
				currentSession.save(pay);
			}

			
}
