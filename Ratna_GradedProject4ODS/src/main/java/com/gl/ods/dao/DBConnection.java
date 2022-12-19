package com.gl.ods.dao;

import java.sql.Connection;
import java.sql.DriverManager;

//Singleton Pattern
public class DBConnection {
	
	private static Connection con;
	
	public static Connection getConnection()
	{
		if(con==null)
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/revision", "root", "Mysql@123");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		}
		else
			return con;
	}

}
