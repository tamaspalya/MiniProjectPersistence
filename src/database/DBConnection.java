package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private Connection connection = null;
	private static DBConnection dbConnection;
	
	private static final String databaseName = "miniproject"; // MiniProjectPersistence
	private static final String serverAddress = "localhost"; // hildur.ucn.dk
	private static final int serverPort = 1433;
	private static final String userName = "sa"; // dmai0920_1086316
	private static final String password = "secret2021"; // Password1!
	
	private DBConnection() throws DataAccessException {
		
		String connectionUrl = String.format("jdbc:sqlserver://%s:%d;databaseName=%s;user=%s;password=%s", 
				serverAddress, serverPort, databaseName, userName, password);
		
		try {
			connection = DriverManager.getConnection(connectionUrl);
		} catch (SQLException e) {
			throw new DataAccessException(String.format("Could not connect to database %s@%s:%d user %s", databaseName,
					serverAddress, serverPort, userName), e);
		}
	}
	
	public static synchronized DBConnection getInstance() throws DataAccessException {
		if(dbConnection == null) {
			dbConnection = new DBConnection();
		}
		return dbConnection;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void disconnect() {
		try {
			connection.close();
			dbConnection = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
