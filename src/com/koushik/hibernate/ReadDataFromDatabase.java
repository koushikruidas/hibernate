package com.koushik.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadDataFromDatabase {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			Student binayak = session.get(Student.class, 7);
			
			session.getTransaction().commit();
			
			System.out.println(binayak.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}
}
