package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import database.DBProduct;
import database.DataAccessException;
import model.Product;

class TestDBProduct {

	@Test
	void testFindById() throws SQLException, DataAccessException {
		DBProduct dbProduct = new DBProduct();
		
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
		assertNotNull("Product was found by id - product cannot be null", product);
		
		assertEquals(name, product.getName());
		assertEquals(purchasePrice, product.getPurchasePrice());
		assertEquals(salesPrice, product.getSalesPrice());
		assertEquals(rentPrice, product.getRentPrice());
		assertEquals(countryOfOrigin, product.getCountryOfOrigin());
		assertEquals(minStock, product.getMinStock());
		assertEquals(stock, product.getStock());
		assertEquals(supplierId, product.getSupplierId());


	}
	
	

}
