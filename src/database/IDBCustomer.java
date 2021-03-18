package database;

import java.util.List;

import model.Customer;

public interface IDBCustomer {

	List<Customer> findAll();
	
	Customer findById(int id);
	
	void update(Customer customer);
}
