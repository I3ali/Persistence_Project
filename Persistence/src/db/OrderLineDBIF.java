package db;

import java.sql.SQLException;
import java.util.List;

import model.OrderLine;

public interface OrderLineDBIF {
	
	 OrderLine create(OrderLine orderLine) throws SQLException;
}