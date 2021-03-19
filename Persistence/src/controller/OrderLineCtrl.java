package controller;

import java.sql.SQLException;
import java.util.List;

import model.*;
import db.*;

import controller.ProductCtrl;
import controller.SaleOrderCtrl;

public class OrderLineCtrl {
    private OrderLineDB orderLineDb;

    public OrderLineCtrl() {
        orderLineDb = new OrderLineDB();
    }

    public boolean addOrderLine(int quantity, int p, int s) {
    	try {
			orderLineDb.create(new OrderLine(quantity, p, s));
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
    	return true;
    }
}