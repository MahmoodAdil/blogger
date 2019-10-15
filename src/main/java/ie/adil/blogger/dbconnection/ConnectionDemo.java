package ie.adil.blogger.dbconnection;

import java.sql.Connection;

public class ConnectionDemo {

	public static void main(String[] args){
		ConnectionConfiguration cc = ConnectionConfiguration.getInstance();
		Connection connection=cc.getConnection();

	}

}
