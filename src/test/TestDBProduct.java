package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import database.DBProduct;
import database.DataAccessException;
import model.Product;

class TestDBProduct {
	
	private DBProduct dbProduct = null;

	@Test
	void testFindById() throws SQLException, DataAccessException {
		dbProduct = new DBProduct();
		
		int id = 2;
		String name = "cowboy hat";
		BigDecimal purchasePrice = new BigDecimal(10.00).setScale(2);
		BigDecimal salesPrice = new BigDecimal(25.00).setScale(2);
		BigDecimal rentPrice = new BigDecimal(-1.00).setScale(2);
		String countryOfOrigin = "China";
		int minStock = 50;
		int stock = 100;
		int supplierId = 1;
		
		Product product = dbProduct.findById(id);
		assertNotNull("Product was not found by id - product cannot be null", product);
		
		assertEquals(name, product.getName());
		assertEquals(purchasePrice, product.getPurchasePrice());
		assertEquals(salesPrice, product.getSalesPrice());
		assertEquals(rentPrice, product.getRentPrice());
		assertEquals(countryOfOrigin, product.getCountryOfOrigin());
		assertEquals(minStock, product.getMinStock());
		assertEquals(stock, product.getStock());
		assertEquals(supplierId, product.getSupplierId());
	}
	
	@Test
	public void testFindByIds() throws IllegalArgumentException, SQLException, DataAccessException {
		dbProduct = new DBProduct();
		
		List<Product> expectedProducts = new ArrayList<Product>();
		expectedProducts.add(dbProduct.findById(2));
		expectedProducts.add(dbProduct.findById(3));
		expectedProducts.add(dbProduct.findById(4));
		
		List<Integer> product_ids = new ArrayList<Integer>();
		product_ids.add(2);
		product_ids.add(3);
		product_ids.add(4);
		
		List<Product> returnedProducts = dbProduct.findByIds(product_ids);
		
		assertEquals("The two arrays are the same size", expectedProducts.size(), returnedProducts.size());
		
		for(int i = 0; i < expectedProducts.size(); i++) {
			assertEquals("Expected product is equal to the returned product", 
					expectedProducts.get(i), returnedProducts.get(i));
		}
	}
}
