package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import database.DBCustomer;
import database.DataAccessException;
import database.IDBCustomer;
import model.Customer;

class TestDBCustomer {

	@Test
	void testFindByName() throws DataAccessException, SQLException {
		IDBCustomer dbCustomer = new DBCustomer();
		
		Customer customer = dbCustomer.findByName("The Greatest Gay Carnival");
		
		int id = 1;
		String address = "Østerågade 5";
		String zipcode = "9200";
		String city = "Aalborg";
		String phone_no = "+4542098832";
		
		assertNotNull("Customer found - customer cannot be null", customer);
		assertEquals(id, customer.getId());
		assertEquals(address, customer.getAddress());
		assertEquals(zipcode, customer.getZipcode());
		assertEquals(city, customer.getCity());
		assertEquals(phone_no, customer.getPhoneNo());
	}

}
