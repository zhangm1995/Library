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
	if(identity.equals("�˿�")){
	    ResultSet result = null;
	    try {
		result = stat.executeQuery("select password from CUSTOMER where CUSTOMERID ='"+userId+"' and password ='"+password+"'");
	    } catch (SQLException e) {
		return e.getMessage();
	    }
	    if(result.next()==false)  return "�û�����������"; //˵��result�ǿյ�,˵��id����
	    	else return "VALIDUSER";
	}
	if(identity.equals("���Ա")){
	    ResultSet result = null;
	    try {
		result = stat.executeQuery("select password from COURIER where COURIERID ='"+userId+"'");
	    } catch (SQLException e) {
		return e.getMessage();
	    }
	    if(result.next()==false)  return "�û������"; //˵��result�ǿյ�,˵��id����
	    	else if(!result.getString("password").equals(password)) return "�������";//˵��id�ԣ����벻��
	    	else return "VALIDUSER";
	}
	if(identity.equals("����Ա")){
	    if(userId.equals("admin")&&password.equals("admin")){
		return "VALIDUSER";
	    }else {
		return "�û������";
	    }
	}
	return "WRONG_LOGIC";
    }
    
    
    
    //����Ϊ���Բ���
    public static void main(String[] args) throws SQLException {
	Connection con = ConnectToDB();
	String result = LogInCheck.isLogin("�˿�", "001", "001", con);
	System.out.println(result);
    }

    
    private static Connection ConnectToDB()
	{
		Connection con = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e)
		{
			System.out.println("�Ҳ�������");
		}
		String url = "jdbc:oracle:" + "thin:@127.0.0.1:1521:xe";
		String user = "myfirstdatabase";
		String key = "6176846";
		try
		{
			con = DriverManager.getConnection(url, user, key);
		} catch (SQLException se)
		{
			System.out.println("��ݿ�����ʧ�ܣ�"); se.printStackTrace();
		}
		return con;
	}
}
