package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Product;

public class DBProduct implements IDBProduct {

	private PreparedStatement p_stmt = null;
	private DBConnection dbConnection = null;
	
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findById(int id) throws SQLException, DataAccessException {
		Product product = null;
		String query = "select * from Product where id = ?";
		
		dbConnection = DBConnection.getInstance();
		
		p_stmt = dbConnection.getConnection().prepareStatement(query);
		p_stmt.setInt(1, id);
		
		ResultSet rs = p_stmt.executeQuery();
		
		if(rs.next()) {
			product = buildObject(rs);
		}
		
		return product;
	}
	
	@Override
	public List<Product> findByIds(List<Integer> ids) throws SQLException, DataAccessException {
		List<Product> products = null;
		
		for(int i = 0; i < ids.size(); i++) {
			products.add(findById(ids.get(i)));
		}
		
		return products;
	}

	@Override
	public List<Product> checkStock(List<Integer> product_ids, List<Integer> num_wanted) throws IllegalArgumentException, SQLException, DataAccessException {
		if(product_ids.size() != num_wanted.size()) {
			throw new IllegalArgumentException("Lists must be the same size");
		}
		List<Product> products = null;
		
		for(int i = 0; i < product_ids.size(); i++) {
			products.add(findById(product_ids.get(i)));
		}
		
		return products;
	}
	
	private Product buildObject(ResultSet rs) throws SQLException {
		return new Product(rs.getInt(1), rs.getString(2), rs.getBigDecimal(3).setScale(2), 
				rs.getBigDecimal(4).setScale(2), rs.getBigDecimal(5).setScale(2), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
	}
}
