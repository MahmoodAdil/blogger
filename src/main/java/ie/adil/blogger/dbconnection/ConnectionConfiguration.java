package ie.adil.blogger.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


public class ConnectionConfiguration {
	
	private static volatile  ConnectionConfiguration instance = null;
	
	private ConnectionConfiguration(){}
	
	private static final String url = "jdbc:postgresql://localhost:5432/bloggerhub"; 
	private static final String user = "postgres";
	private static final String password = "postgres";

	public static ConnectionConfiguration getInstance(){
		if (instance == null) {
			synchronized(ConnectionConfiguration.class) {
				if (instance == null) {
					instance = new ConnectionConfiguration();
				}
			}
		}
		return instance;
	}


	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Successfully connected to the DB server.");

		} catch (SQLException e) {
			System.err.println("Connec	FAIL for DB "+e);
		}
		return conn;
	}
}