package com.koushik.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentData {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Creating a new student object");
			Student newStudent = new Student("Koushik", "Ruidas","koushikruidas@gmail.com");
			
			System.out.println("Starting the transaction");
			session.beginTransaction();
			
			System.out.println("Saving the student");
			session.save(newStudent);

			System.out.println("Commit");
			session.getTransaction().commit();
			
			System.out.println("Done!!");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}
}
