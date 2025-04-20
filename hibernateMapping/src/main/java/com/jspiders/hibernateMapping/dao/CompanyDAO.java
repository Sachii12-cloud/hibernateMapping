package com.jspiders.hibernateMapping.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernateMapping.dto.Company;
import com.jspiders.hibernateMapping.dto.Emplyoee;

public class CompanyDAO {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	public static void main(String[] args) {
		Emplyoee employee1 = new Emplyoee();
		employee1.setName("Ramesh");
		employee1.setEmail("ramesh@gmail.com");

		Emplyoee employee2 = new Emplyoee();
		employee2.setName("Suresh");
		employee2.setEmail("suresh@gmail.com");

		Collection<Emplyoee> employees = new ArrayList<Emplyoee>();
		employees.add(employee1);
		employees.add(employee2);

		Company company = new Company();
		company.setName("TCS");
		company.setLocation("Pune");
		company.setEmplyoee(employees);

		openConnection();
		entityTransaction.begin();
		entityManager.persist(employee1);
		entityManager.persist(employee2);
		entityManager.persist(company);
		entityTransaction.commit();
		closeConnection();

	}

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate_mappings");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	private static void closeConnection() {
		if (entityManagerFactory != null)
			entityManagerFactory.close();
		if (entityManager != null)
			entityManager.close();
		if (entityTransaction != null) {
			if (entityTransaction.isActive())
				entityTransaction.rollback();
		}
	}
}
