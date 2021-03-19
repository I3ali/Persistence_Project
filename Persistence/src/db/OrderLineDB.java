package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.OrderLine;
import controller.OrderLineCtrl;

public class OrderLineDB implements OrderLineDBIF {
	
	public OrderLine create(OrderLine orderLine) throws SQLException {
		String sql = String.format("insert into OrderLine (saleOrder_id, product_id, quantity) values ('%s', '%s', '%s')", orderLine.getSaleOrderId(), orderLine.getProductId(), orderLine.getQuantity());
		DBConnection.getInstance().executeUpdate(sql);
		return orderLine;
	}
	
	private List<OrderLine> buildObjects(ResultSet rs) throws SQLException {
		ArrayList<OrderLine> res = new ArrayList<>();
		while(rs.next()) {
			OrderLine b = buildObject(rs);
			res.add(b);
		}
		return res;
	}
    
	private OrderLine buildObject(ResultSet rs) throws SQLException {
		OrderLine b = null;
		b = new OrderLine(rs.getInt("quantity"), rs.getInt("product_id"), rs.getInt("saleOrder_id"));

		return b;
	}
}