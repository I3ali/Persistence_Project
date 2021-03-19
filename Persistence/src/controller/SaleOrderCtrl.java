package controller;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import model.*;
import db.*;

//import controller.CustomerCtrl;

public class SaleOrderCtrl
{
    private SaleOrderDB saleOrderDb;
//	private CustomerCtrl cCtrl;
	
    public SaleOrderCtrl()
    {
        saleOrderDb = new SaleOrderDB();
//		cCtrl = new CustomerCtrl();
    }
    
	public SaleOrderDB getSaleOrderDb() {
		return saleOrderDb;
	}

//	public Customer getCustomerByID(int id) {
//        Customer p = null;
//        try {
//			p = cCtrl.getCustomerDb().findById(id);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return p;
//    } 

    public boolean addSaleOrder(int id, LocalDateTime currentDate, float amount, String deliveryStatus, Date date1, int customerId, int invoiceId) {
    	try {
			saleOrderDb.create(new SaleOrder(id, currentDate, amount, deliveryStatus, date1, customerId, invoiceId));
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return true;
    }
    
    public boolean removeSaleOrder(int id) {
    	try {
			saleOrderDb.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return true;
    }
    
//    public List<SaleOrder> getAll() {
//        List<SaleOrder> sol = null;
//        try {
//			sol = saleOrderDb.getAll();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return sol;
//
//    }
//    
    
    public int getLastId() {
    	int id = 180;
    	try {
			id = saleOrderDb.findLastId();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return id;
    }
    
    
    public boolean updateSaleOrder(int id, SaleOrder SO) {
        try {	
        	System.out.println(SO.getDeliveryDate());
        	SO.setId(id);
			saleOrderDb.update(SO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return true;
    }}

	
//	public boolean findById(int id) {
//        try {
//			saleOrderDb.findById(id);
//		} 
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return true;
//	}
//
//	public List<SaleOrder> findByName(String name) {
//        List<SaleOrder> sol2 = null;
//        try {
//			sol2 = saleOrderDb.findByName(name);
//		} 
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return sol2;
//	}   
//}