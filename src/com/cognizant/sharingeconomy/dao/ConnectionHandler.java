package com.cognizant.sharingeconomy.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {      

	public static Connection getConnection() throws Exception
	{
		Properties p=new Properties();
			FileReader reader;
		reader = new FileReader("C:\\Users\\806801\\git\\Sharing_Economy1\\Sharing_Economy1\\src\\connection.properties");
		p.load(reader);	
		String url=p.getProperty("connection-url");
			String user=p.getProperty("user");
			String pass=p.getProperty("password");
			String driver=p.getProperty("driver");
			
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,user,pass);
	
			return con;
		
	}
	
	
}
