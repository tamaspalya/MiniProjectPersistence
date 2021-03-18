package database;

import java.util.List;

import model.SaleOrder;

public interface IDBSaleOrder {
	
	List<SaleOrder> findAll();
	
	SaleOrder findById(int id);
}
