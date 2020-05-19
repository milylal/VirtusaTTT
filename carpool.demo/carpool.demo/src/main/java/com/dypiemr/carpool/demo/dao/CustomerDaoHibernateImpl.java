package com.dypiemr.carpool.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dypiemr.carpool.demo.entity.Customer;


@Repository
public class CustomerDaoHibernateImpl implements CustomerDAO {

	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public CustomerDaoHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	public List<Customer> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Customer> theQuery =
				currentSession.createQuery("from Customer", Customer.class);
		
		// execute query and get result list
		List<Customer> customer = theQuery.getResultList();
		
		// return the results		
		return customer;
	}
		@Override
		public Customer findById(int theId) {

			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			
			// get the employee
			Customer theCustomer =
					currentSession.get(Customer.class, theId);
			
			// return the employee
			return theCustomer;
		}


		@Override
		public void save(Customer theCustomer) {

			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			
			// save employee
			currentSession.saveOrUpdate(theCustomer);
		}


		@Override
		public void deleteById(int theId) {
			
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
					
			// delete object with primary key
			Query theQuery = 
					currentSession.createQuery(
							"delete from Customer where id=:customerId");
			theQuery.setParameter("customerId", theId);
			
			theQuery.executeUpdate();
		}

	

}







