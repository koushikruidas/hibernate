package com.koushik.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteObject {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Student student = session.get(Student.class, 9); // gets a student object.
			session.delete(student); // deleted the same object from the database.
			session.getTransaction().commit();
			
			// Deleting multiple object at one go
			session.beginTransaction();
			session.createQuery("delete from Student where lastName='Ghosh'").executeUpdate();
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

}
