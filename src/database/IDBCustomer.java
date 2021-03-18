package database;

import java.util.List;

import model.Customer;

public interface IDBCustomer {

	List<Customer> findAll();

	Customer findById(int id);
	
	Customer findByName(String name);
	
	void update(Customer customer);
}
