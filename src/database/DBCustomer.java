package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Customer;

public class DBCustomer implements IDBCustomer {
	
	private PreparedStatement p_stmt = null;
	private DBConnection dbConnection = null;

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Customer findByName(String name) throws SQLException, DataAccessException {
		
		Customer customer = null;
		
		String query = "select * from customer where name = ?";
		dbConnection = DBConnection.getInstance();
			
		p_stmt = dbConnection.getConnection().prepareStatement(query);
		p_stmt.setString(1, name);
			
		ResultSet rs = p_stmt.executeQuery();
			
		if(rs.next()) {
			customer = buildObject(rs);
		}

		return customer;
	}

	private Customer buildObject(ResultSet rs) throws SQLException {
		return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub

	}

}
