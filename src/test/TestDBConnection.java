package test;

import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;

import database.DBConnection;
import database.DataAccessException;

class TestDBConnection {

	@Test
	void testConnectionToDatabase() throws DataAccessException {
		DBConnection dbConnection = DBConnection.getInstance();
		
		assertNotNull("Connection to the database failed", dbConnection);
		dbConnection.disconnect();
	}
	
	@Test
	void testConnectionToUCNDatabase() throws DataAccessException {
		DBConnection dbConnection = DBConnection.getInstance();
		DBConnection.setConnectionInfo("dmai0920_1086316", "hildur.ucn.dk", 1433, "dmai0920_1086316", "Password1!");
		
		assertNotNull("Successfull connection to the database", dbConnection);
		
		dbConnection.disconnect();
	}

}
