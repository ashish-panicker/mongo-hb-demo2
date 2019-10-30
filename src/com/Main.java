package com;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Address;
import model.Student;
import model.Zip;

public class Main {
	
	private static EntityManagerFactory factory;

	public static void main(String[] args) {
		
		
		Address addr1 = new Address("Lane 2", "Bangalore", "Karnataka");
		Address addr2 = new Address("Lane 0", "Tvpm", "Kerala");
		
		Set<Address> addrs = new HashSet<>();
		addrs.add(addr1);
		addrs.add(addr2);
		
		Student student = new Student("Ashish", "ashish@gmail.com", addrs);
		
		factory = HibernateOGMUtil.getEntityManagerFactory();
		
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		//em.persist(student);
		
		student = em.createQuery("from Student s where s.name = :name", Student.class)
				.setParameter("name", "Ashish")
				.getResultList()
				.get(0);
		student.setAddresses(addrs);
		
		
		em.merge(student);
		
		
		em.getTransaction().commit();
		
		System.out.println("done...");
				
	}
}
