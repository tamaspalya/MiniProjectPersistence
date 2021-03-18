package database;

import java.sql.SQLException;

public class DataAccessException extends Exception {

	public DataAccessException(String format, SQLException e) {}
	
}
