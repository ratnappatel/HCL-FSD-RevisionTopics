package com.hcl.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static Connection con;
	public static Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","Mysql@123");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}

}
