package com.database;

// import java.sql.DriverManager;
// import java.sql.SQLException;

// public class JDBC {
// 	public static void main(String[] args) {
// 		try {
// 			DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system ","root","");
// 		} catch (SQLException e) {
// 			e.printStackTrace();
// 		}
// 	}
// }


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

	private static final Connection connection = getConnection();

	private static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static com.mysql.cj.api.jdbc.Statement getStatement() {
		try {
			return (com.mysql.cj.api.jdbc.Statement) connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}