package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;

public class LibConnection {
	public static final String url = "jdbc:mysql://127.0.0.1:3306/library";
	public static final String user = "root";
	public static final String password = "6176846";
	public static final String driver = "com.mysql.jdbc.Driver";
	private static Statement statement = Init();

	private static Statement Init(){
		Connection conn =null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			statement = conn.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statement;
	}
	
	public static Statement getStatement(){
       return statement;
	}
	
	public static void main(String args[]){
		Statement statement = null;
	    statement = LibConnection.getStatement();
		String sql = "select * from user";
		ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name = null;
		String sex = null;
		try {
			while (rs.next()) {
				name = rs.getString("name");
				sex = rs.getString("sex");
				System.out.println(name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}
}
