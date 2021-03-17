package db;

import java.sql.SQLException;
import java.util.List;

import model.SaleOrder;

public interface SaleOrderDBIF {
	
	 SaleOrder create(SaleOrder saleOrder) throws SQLException;
	 
	 SaleOrder update(SaleOrder saleOrder) throws SQLException;
	 
	 boolean delete(int id) throws SQLException;
	 
	 SaleOrder findById(int id) throws SQLException;
	 
	 //List<SaleOrder> findByName(String email) throws SQLException;
	 
	 List<SaleOrder> getAll() throws SQLException;
}