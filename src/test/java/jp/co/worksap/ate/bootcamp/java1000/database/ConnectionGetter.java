package jp.co.worksap.ate.bootcamp.java1000.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jp.co.worksap.ate.bootcamp.java1000.database.jdbc.MockConnection;

public final class ConnectionGetter {

	public ConnectionGetter(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}

	private String url = null;
	private String user = null;
	private String password = null;

	public Connection getNewConnection() throws SQLException {
		Connection con = DriverManager.getConnection(url, user, password);
		return new MockConnection(con); 
	}

}
