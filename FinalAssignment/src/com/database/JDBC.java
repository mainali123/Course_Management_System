package com.database;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
	public static void main(String[] args) {
		try {
			DriverManager.getConnection("jdbc:mysql://localhost:3306/course_manaagement_system ","root","");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
