package control;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

import database.DBSaleOrder;
import database.DataAccessException;
import database.IDBSaleOrder;
import model.SaleOrder;

public class SaleOrderController {
	
	private IDBSaleOrder dbSaleOrder = new DBSaleOrder();
	
	public SaleOrder createOrder(Date date, BigDecimal amount, String deliveryStatus, Date deliveryDate, int customerId, int invoiceNumber) throws SQLException, DataAccessException {                                                                                                      
		SaleOrder saleOrder = new SaleOrder(-1, date, amount, deliveryStatus, deliveryDate, customerId, invoiceNumber, null);
		dbSaleOrder.insertSaleOrder(saleOrder);
		dbSaleOrder.insertProductSaleOrders(saleOrder);
		return saleOrder;
	}
	
	
}
