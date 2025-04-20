package com.jspiders.hibernateMapping.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernateMapping.dto.AadharCard;
import com.jspiders.hibernateMapping.dto.User;

public class UserDAO {
	
	private static EntityManagerFactory entityManagerFactory;
	private static  EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		AadharCard aadharCard = new AadharCard();
		aadharCard.setAadharNumber(876765665456l);
		
		User user = new User();
		user.setName("Sachin");
		user.setMobile(8767676578l);
		user.setAadharCard(aadharCard);
		
		openConnection();
		entityTransaction.begin();
		entityManager.persist(aadharCard);
		entityManager.persist(user);
		entityTransaction.commit();
		closeConnection();
	}

	private static void openConnection() {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate_mappings");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
		
		
	}

	private static void closeConnection() {
		
		if(entityManagerFactory != null)
			entityManagerFactory.close();
		if(entityManager != null)
			entityManager.close();
		if(entityTransaction != null)
			if(entityTransaction.isActive())
				entityTransaction.rollback();
	
		
	}
	

}
