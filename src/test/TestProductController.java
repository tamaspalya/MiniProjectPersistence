package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import control.ProductController;
import database.DBProduct;
import database.DataAccessException;
import model.Product;

class TestProductController {
	
	private ProductController productCtrl = new ProductController();

	@Test
	public void testCheckStock() throws IllegalArgumentException, SQLException, DataAccessException {
		
		List<Product> expectedProducts = new ArrayList<Product>();
		expectedProducts.add(productCtrl.findById(2));
		expectedProducts.add(productCtrl.findById(3));
		expectedProducts.add(productCtrl.findById(4));
		
		List<Integer> product_ids = new ArrayList<Integer>();
		product_ids.add(2);
		product_ids.add(3);
		product_ids.add(4);
		
		List<Integer> num_wanted = new ArrayList<Integer>();
		num_wanted.add(50);
		num_wanted.add(40);
		num_wanted.add(200);
		
		List<Product> returnedProducts = productCtrl.checkStock(product_ids, num_wanted);
		
		assertEquals("The two arrays are not the same size", expectedProducts.size(), returnedProducts.size());
		
		for(int i = 0; i < expectedProducts.size(); i++) {
			assertEquals("Expected product is not equal to the returned product", 
					expectedProducts.get(i), returnedProducts.get(i));
		}
	}

}
