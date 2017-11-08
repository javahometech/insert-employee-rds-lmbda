package com.amazonaws.lambda.createemployee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RDSUtil {
	private static String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static String USER_NAME = "valtech";
	private static String PASSWORD = "valtech123";
	private static String RDS_ENDPOINT = "jdbc:mysql://valtech-training.cqx1rqbejdw5.us-west-2.rds.amazonaws.com:3306/valtechdev";
	static {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getRDSConnection() {
		Connection con = null;
		try {
			return DriverManager.getConnection(RDS_ENDPOINT, USER_NAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
