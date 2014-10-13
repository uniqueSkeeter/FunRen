package com.fr.station.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class ApacheSource {

	private static BasicDataSource bs;
	public static void main(String[] args) throws SQLException{
	
		testSqlServer();
		
	}	
	public static void testSqlServer(){
//							com.microsoft.jdbc.sqlserver.SQLServerDriver
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
//		String dbURL = "jdbc:microsoft:sqlserver://localhost:3377; DatabaseName=STATION2013";  
//		String dbURL = "jdbc:sqlserver://192.168.7.2:1174;DatabaseName=FRCENTER";  
		String dbURL = "jdbc:sqlserver://localhost:3377;DatabaseName=FRCENTER";  
		String userName = "sa";//sa为SQL用户名  
		String userPwd = "sql";//SQL密码  
		 
		java.sql.Connection dbConn;  
		     try {
				Class.forName(driverName);
				dbConn = DriverManager.getConnection(dbURL, userName, userPwd);  
				System.out.println("Connection Successful!");   
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}  
		 
		 
		 
	}		 
}
