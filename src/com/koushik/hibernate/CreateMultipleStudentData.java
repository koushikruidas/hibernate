package com.koushik.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateMultipleStudentData {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			Student student1 = new Student("Tandra","Bhawal","tandrabhawal@gmail.com");
			Student student2 = new Student("Binayak","Ghosh","ghoshbinayak@gmail.com");
			Student student3 = new Student("Tanmoy","Mondal","tanmoymondal@gmail.com");
			Student student4 = new Student("Subrata","Maity","subratamaity@gmail.com");
			
			session.beginTransaction();
			
			session.save(student1);
			session.save(student2);
			session.save(student3);
			session.save(student4);
			
			session.getTransaction().commit();
			
			// Will read data from the database
			
			  session = factory.getCurrentSession(); session.beginTransaction();
			  
			  Student uma = session.get(Student.class, 4);
			  System.out.println("Printing lastname: "+uma.getLastName());
			  session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}
}
