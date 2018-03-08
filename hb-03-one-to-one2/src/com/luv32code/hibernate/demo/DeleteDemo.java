package com.luv32code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;
import com.luv2code.hibernate.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
		
			// start transacction
			session.beginTransaction();
		
			// get the instructor by the primary key/id
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Found instructor: " + tempInstructor);
			// delete the instructor
			if(tempInstructor != null) {
				System.out.println("Deleting instructor: " + tempInstructor);
				
				// Note: will ALSO delete associated "detials" object
				// because of CascadeType.ALL
				session.delete(tempInstructor);
			}
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!");
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
