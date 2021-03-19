package db;

import java.sql.SQLException;
import java.util.List;

import model.Supplier;

public interface SupplierDBIF {
	 Supplier create(Supplier supplier) throws SQLException;
	 
	 Supplier update(Supplier supplier) throws SQLException;
	 
	 boolean delete(int id) throws SQLException;
	 
	 Supplier findById(int id) throws SQLException;
	 
	 List<Supplier> findByName(String name) throws SQLException;
	 
	 List<Supplier> getAll() throws SQLException;
}
