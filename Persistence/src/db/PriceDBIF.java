package db;

import java.sql.SQLException;
import java.util.List;

import model.Price;

public interface PriceDBIF {
	
	 Price create(Price price) throws SQLException;
	 
	 Price update(Price price) throws SQLException;
	 
	 boolean delete(int id) throws SQLException;
	 
	 Price findByProductId(int productId) throws SQLException;
	 
	 List<Price> findByPrice(int price) throws SQLException;
	 
	 List<Price> getAll() throws SQLException;
}