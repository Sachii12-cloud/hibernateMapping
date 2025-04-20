package com.jspiders.hibernateMapping.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernateMapping.dto.BloodReport;
import com.jspiders.hibernateMapping.dto.Patient;

public class PatientDAO {
	
	private   static  EntityManagerFactory entityManagerFactory;
	private static  EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		Patient patient = new Patient();
		patient.setName("Ramesh");
		patient.setMobile(767678767l);
		
		BloodReport bloodReport = new BloodReport();
		bloodReport.setDescription("xyz");
		bloodReport.setPatient(patient);
			
		
		openConnection();
		entityTransaction.begin();
		entityManager.persist(bloodReport);
		entityManager.persist(patient);
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
	public void addPatient(Patient patient) {
		// TODO Auto-generated method stub
		
	}

	

}
