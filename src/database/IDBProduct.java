package database;

import java.sql.SQLException;
import java.util.List;

import model.Product;

public interface IDBProduct {
	
	List<Product> findAll();
	
	Product findById(int id) throws SQLException, DataAccessException;
	
	List<Product> findByIds(List<Integer> ids) throws SQLException, DataAccessException;
	
	List<Product> checkStock(List<Integer> product_ids, List<Integer> num_wanted) throws IllegalArgumentException, SQLException, DataAccessException;
	
}
