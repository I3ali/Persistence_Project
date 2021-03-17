package db;

import java.sql.SQLException;
import java.util.List;

import model.Customer;

public interface CustomerDBIF {
	
	 Customer create(Customer customer) throws SQLException;
	 
	 Customer update(Customer customer) throws SQLException;
	 
	 boolean delete(int id) throws SQLException;
	 
	 Customer findById(int id) throws SQLException;
	 
	 List<Customer> findByName(String name) throws SQLException;
	 
	 List<Customer> getAll() throws SQLException;
}