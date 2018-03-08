package com.luv32code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create student object
			System.out.println("Creating new student object...");
			Student student = new Student("Jonathan", "Perez", "jonathanperezmota@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student object...");
			session.save(student);	
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!");
		}catch(Exception exc) {
			factory.close();
		}
	}

}
