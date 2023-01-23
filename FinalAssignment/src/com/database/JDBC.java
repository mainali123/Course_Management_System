package com.database;

// import java.sql.DriverManager;
// import java.sql.SQLException;

// public class JDBC {
// 	public static void main(String[] args) {
// 		try {
// 			DriverManager.getConnection("jdbc:mysql://localhost:3306/course_manaagement_system ","root","");
// 		} catch (SQLException e) {
// 			e.printStackTrace();
// 		}
// 	}
// }

import java.sql.*;

public class JDBC {
    private Connection connection;

    public JDBC() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://hostname:port/dbname", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(query);
    }

    public void close() throws SQLException {
        connection.close();
    }
}