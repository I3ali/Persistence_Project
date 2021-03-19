package db;

import java.sql.SQLException;
import java.util.List;

import model.Product;

public interface ProductDBIF {
	
	 Product create(Product product) throws SQLException;
	 
	 Product update(Product product) throws SQLException;
	 
	 boolean delete(int id) throws SQLException;
	 
	 Product findById(int id) throws SQLException;
	 
	 List<Product> findByName(String name) throws SQLException;
	 
	 List<Product> getAll() throws SQLException;

	float getPriceById(int id) throws SQLException;
}