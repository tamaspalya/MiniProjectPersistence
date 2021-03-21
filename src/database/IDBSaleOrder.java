package database;

import java.sql.SQLException;
import java.util.List;

import model.SaleOrder;

public interface IDBSaleOrder {
	
	List<SaleOrder> findAll();
	
	SaleOrder findById(int id);
	
	void insertSaleOrder(SaleOrder saleOrder) throws SQLException, DataAccessException;
	
	void removeById(int id) throws DataAccessException, SQLException;
	
	int insertProductSaleOrders(SaleOrder saleOrder) throws DataAccessException, SQLException;
}
