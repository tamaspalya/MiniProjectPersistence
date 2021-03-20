package control;

import java.sql.SQLException;

import database.DBCustomer;
import database.DataAccessException;
import database.IDBCustomer;
import model.Customer;

public class CustomerController {

	private IDBCustomer dbCustomer = new DBCustomer();
	
	public Customer getCustomer(String name) throws DataAccessException, SQLException
	{
		return dbCustomer.findByName(name);
	}
}
