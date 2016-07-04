package com.entity;

import java.sql.ResultSet;
import java.sql.Statement;

import com.test.LibConnection;

public class User {
	public String cardID;
	
	
	
	Statement statement = LibConnection.getStatement();
	
	public User(){
		
	}
	public User(String cardID){
		this.cardID = cardID;
	}
	
	public ResultSet showMyBook(){//显示当前用户所接所有书籍
		
		return null;
	}
	
	
	
}
