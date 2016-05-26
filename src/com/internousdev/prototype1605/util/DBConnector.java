package com.internousdev.prototype1605.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector
{
	private static String driverName = "com.mysql.jdbc.Driver";

	private static String url = "jdbc:mysql://localhost/datalist";

	private static String user = "root";

	private static String pass = "mysql";

	public Connection getConnection()
	{
		Connection con = null;
		try
		{
			Class.forName(driverName);
			con = DriverManager.getConnection(url,user,pass);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
