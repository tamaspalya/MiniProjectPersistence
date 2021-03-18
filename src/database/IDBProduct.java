package database;

import java.util.List;

import model.Product;

public interface IDBProduct {
	
	List<Product> findAll();
	
	Product findById(int id);
}
