package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import database.DBSaleOrder;
import database.DataAccessException;
import database.IDBSaleOrder;
import model.OrderLine;
import model.SaleOrder;

class TestDBSaleOrder {

	static SaleOrder saleOrder = null;
	static IDBSaleOrder dbSaleOrder = null;
	
	@BeforeClass
	public static void valamifos() {
		
		
	}
	
	@Test
	void testRemoveById() {
		//TO-DO

	}
	
	@Test
	void testInsertSaleOrder() throws SQLException, DataAccessException {
		
		setUp();
		
		dbSaleOrder.insertSaleOrder(saleOrder);
		
		assertTrue("Insertion failed, Id not recieved", saleOrder.getId() > 0);
		dbSaleOrder.removeById(saleOrder.getId());
	}
	
	@Test
	void testInsertProductSaleOrder() throws DataAccessException, SQLException {
		setUp();
		assertNotNull("BeforeClass did not run >:(", saleOrder);
		int rows_affected = dbSaleOrder.insertProductSaleOrders(saleOrder);
		assertEquals("Not enough rows affected", rows_affected, saleOrder.getOrderLine().size());
	}
	
	private void setUp() {
		dbSaleOrder = new DBSaleOrder();
		java.util.Date utilDate = new java.util.Date();
		Date sqlDate = new Date(utilDate.getTime());
		
		Date deliveryDate = Date.valueOf("2021-03-25");
		
		
		saleOrder = new SaleOrder(1, sqlDate, new BigDecimal(5000), "processing", deliveryDate, 1, 1, new OrderLine());
		saleOrder.addProduct(2, 20);
	}
}
