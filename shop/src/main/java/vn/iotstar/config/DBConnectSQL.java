package vn.iotstar.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectSQL {
	private final String serverName = "WINDOWS-PC";
	private final String dbName = "shop";
	private final String portNumber = "1433";
	private final String instance = "";

	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber
				+ ";integratedSecurity=true;databaseName=" + dbName;

		if (instance == null || instance.trim().isEmpty())

			url = "jdbc:sqlserver://" + serverName + ";integratedSecurity=true;databaseName=" + dbName;
		
			//System.out.println(url);
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		return DriverManager.getConnection(url);
	}

	public static void main(String[] args) {
		try {
			System.out.println(new DBConnectSQL().getConnection());
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
