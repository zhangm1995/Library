package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
import com.test.LibConnection;

public class testServlet extends HttpServlet{

	
	HttpSession session = null;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");//防止中文乱码问题
		session = request.getSession();
		String content =  request.getParameter("content");
		System.out.println(content);
		Statement statement =null;
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
				sex = rs.getString("cardID");
				System.out.println(name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		   session.setAttribute("mydata", content);
		   request.getRequestDispatcher("LogResult.jsp").forward(request, response);
	
	}

}
