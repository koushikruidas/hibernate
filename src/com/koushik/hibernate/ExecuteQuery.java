package com.koushik.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ExecuteQuery {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			List<Student> result = session.createQuery("from Student s "
					+ "where s.lastName like '%ruid%'").getResultList();
			
			displayQueryResult(result);
			
			List<Student> result2 = session.createQuery("from Student s "
					+ "where s.firstName like '__u%'").getResultList();
			displayQueryResult(result2);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

	private static void displayQueryResult(List<Student> result) {
		Iterator<Student> listIterator = result.iterator();
		while(listIterator.hasNext()) {
			System.out.println(listIterator.next().toString());
		}
	}

}
