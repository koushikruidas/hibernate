package com.koushik.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateObject {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			Student tandra = session.get(Student.class, 6);
			
			//Changed the firstname from Tandra to Mampi
			tandra.setFirstName("Mampi");
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
}
