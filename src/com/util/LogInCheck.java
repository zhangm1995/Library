package com.util;
import java.sql.*;

public class LogInCheck {
    static Statement  stat = null;
    
    public static String isLogin(String identity,String userId,String password,Connection con) throws SQLException{
	try {
	   stat = con.createStatement();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	if(identity.equals("学生")||identity.equals("老师")){
	    ResultSet result = null;
	    try {
		result = stat.executeQuery("select * from CUSTOMER where CUSTOMERID ='"+userId+"' and password ='"+password+"'");
	    } catch (SQLException e) {
		return e.getMessage();
	    }
	    if(result.next()==false)  return "用户名或密码错误"; 
	    	else return "VALIDUSER";
	}
	if(identity.equals("管理员")){
	    ResultSet result = null;
	    try {
		result = stat.executeQuery("select password from COURIER where COURIERID =='"+userId+"' and password ='"+password+"'");
	    } catch (SQLException e) {
		return e.getMessage();
	    }
	    if(result.next()==false)  return "用户名或密码错误"; 
	    	else return "VALIDUSER";
	}
	return "WRONG_LOGIC";
    }
    
    
    
    public static void main(String[] args) throws SQLException {

    }

    
}
