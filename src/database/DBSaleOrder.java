package database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;

import java.util.List;

import model.Product;
import model.SaleOrder;

public class DBSaleOrder implements IDBSaleOrder {
	
	DBConnection dbConnection = null;

	@Override
	public List<SaleOrder> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaleOrder findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertSaleOrder(SaleOrder saleOrder) throws SQLException, DataAccessException {
		dbConnection = DBConnection.getInstance();
		String sql_insert = "insert into SalesOrder values (?, ?, ?, ?, ?, ?)"; // to be fixed to SaleOrder
		PreparedStatement p_stmt = 	dbConnection.getConnection().prepareStatement(sql_insert , Statement.RETURN_GENERATED_KEYS);
		
		p_stmt.setDate(1, saleOrder.getDate());
		p_stmt.setBigDecimal(2, saleOrder.getAmount());
		p_stmt.setString(3, saleOrder.getDeliveryStatus());
		p_stmt.setDate(4, saleOrder.getDeliveryDate());
		p_stmt.setInt(5, saleOrder.getInvoiceNumber());
		p_stmt.setInt(6, saleOrder.getCustomerId());
		
		int affectedRows = p_stmt.executeUpdate();
		
		if (affectedRows == 0) {
	            throw new SQLException("Creating sale order failed, no rows affected.");
	    }
		
		try (ResultSet generatedKeys = p_stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                saleOrder.setId(generatedKeys.getInt(1));
            }
            else {
                throw new SQLException("Creating sale order failed, no ID obtained.");
            }
		}
	}

	@Override
	public void removeById(int id) throws DataAccessException, SQLException {
		dbConnection = DBConnection.getInstance();
		
		String sqlDelete = "delete from SalesOrder where id = ?"; // to fix to SaleOrder
		
		PreparedStatement p_stmt = 	dbConnection.getConnection().prepareStatement(sqlDelete);
		p_stmt.setInt(1, id);
		int affectedRows = p_stmt.executeUpdate();
		
		if (affectedRows == 0) {
            throw new SQLException("Removing sale order failed, no rows affected.");
		}
	}

	@Override
	public int insertProductSaleOrders(SaleOrder saleOrder) throws DataAccessException, SQLException {
		dbConnection = DBConnection.getInstance();
		
		String sqlInsert = "insert into ProductSalesOrder values(?, ?, ?)"; //ProductSaleOrder
				
		List<Integer> product_ids = saleOrder.getOrderLine().getProductIds();
		List<Integer> product_amounts = saleOrder.getOrderLine().getProductAmounts();
		
		//creating multiple line query to insert all rows in one statement
		String multi_query = "";
		for(int i = 0; i < product_ids.size(); i++) {
			multi_query += sqlInsert + ";\n";
		}
		
		PreparedStatement p_stmt = dbConnection.getConnection().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
		
		// each row in the prepared statement
		// has 3 placeholders so we get their
		// indexes(1, 2, 3 then 4, 5, 6....)
		// by multilying our index and adding
		// offsets (0 then 1....)
		
		for(int i = 0; i < product_ids.size(); i++) {
			p_stmt.setInt(i * 3 + 1, product_ids.get(i));
			p_stmt.setInt(i * 3 + 2, saleOrder.getId());
			p_stmt.setInt(i * 3 + 3, product_amounts.get(i));
		}
		

		return p_stmt.executeUpdate();
	}
	
}
