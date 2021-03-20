package database;

import java.sql.SQLException;
import java.util.List;

import model.Customer;

public interface IDBCustomer {

	List<Customer> findAll();

	Customer findById(int id);
	
	Customer findByName(String name) throws DataAccessException, SQLException;
	
	void update(Customer customer);
}
