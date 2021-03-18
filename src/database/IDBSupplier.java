package database;

import java.util.List;
import java.util.function.Supplier;

public interface IDBSupplier {
	
	List<Supplier> findAll();
	
	Supplier findById(int id);
}
