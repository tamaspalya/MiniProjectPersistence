package control;

import java.util.List;
import java.sql.SQLException;

import database.DBProduct;
import database.DataAccessException;
import database.IDBProduct;
import model.Product;

public class ProductController {
	
	private List<Product> checkStock(List<Integer> product_ids, List<Integer> num_wanted) throws IllegalArgumentException, SQLException, DataAccessException {
		if(product_ids.size() != num_wanted.size()) {
			throw new IllegalArgumentException("Lists must be the same size");
		}
		IDBProduct dbproduct = new DBProduct();
		List<Product> products = dbproduct.findByIds(product_ids);
		List<Product> productsInStock = null;
		
		for(int i = 0; i < product_ids.size(); i++) {
			if(products.get(i).getStock() >= num_wanted.get(i)) {
				productsInStock.add(products.get(i));
			}
		}
		
		return productsInStock;
	}
}
