package com.koushik.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DatabaseConnectionTest {
	public static void main(String[] args) {
		String databaseURL = "jdbc:mysql://localhost:3306/Student-Database?useSSL=false&serverTimeZone=UTC";
		String username = "Student-Database";
		String password = "koushikRuidas";
		String sqlstmt = "select * from student where id = ?";
		int id;
		System.out.println("Enter the student id: ");
		Scanner scan = new Scanner(System.in);
		id = scan.nextInt();
		Connection connection = null;
		try {
			System.out.println("Connecting to the datbase: " + databaseURL);
			connection = DriverManager.getConnection(databaseURL, username, password);
			System.out.println("Connection made successfully");
			System.out.println("Preaparing a stmt");
			PreparedStatement select = connection.prepareStatement(sqlstmt);
			connection.setAutoCommit(false);
			select.setInt(1, id);
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			scan.close();
		}
	}

}
