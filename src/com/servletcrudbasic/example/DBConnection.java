package com.servletcrudbasic.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	Connection con = null;

	public Connection getDBconnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basic", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public String getName(String a, String b) {
		String fname = null;
		System.out.println(a + "---->" + b);
		try {
			Statement stmt = getDBconnection().createStatement();
			String query = "select fullname from basiccrud where name='" + a + "'and password='" + b + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {

				fname = rs.getString("fullname");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fname;
	}

	public int deleteName(String a, String b) {
		int rs = 0;
		try {
			Statement stmt = getDBconnection().createStatement();
			String query1 = "Delete from basiccrud where name='" + a + "' and password='" + b + "'";
			rs = stmt.executeUpdate(query1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;

	}

	public int updateName(String a, String b, String c) {
		Statement stmt;
		int rs = 0;
		try {
			stmt = getDBconnection().createStatement();
			String query2 = "update basiccrud set fullname='" + c + "' where name='" + a + "' and password='" + b + "'";
			rs = stmt.executeUpdate(query2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;

	}

	public int InsertName(String a, String b, String c) {
		int rs = 0;
		try {
			Statement stmt = getDBconnection().createStatement();
			String query3 = "Insert into basiccrud(name,password,fullname)values('" + a + "','" + b + "','" + c + "')";
			rs = stmt.executeUpdate(query3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;

	}
}
