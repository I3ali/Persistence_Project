package controller;

import java.sql.SQLException;
import java.util.List;

import model.*;
import db.*;

/**
 * Write a description of class CustomerCtrl here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CustomerCtrl
{
    private CustomerDB customerDb;

    public CustomerCtrl()
    {
        customerDb = new CustomerDB();
    }
    
    public boolean addCustomer(int id, String fname, String lname, String email, String address,
    String phoneNumber) {
 
    	//TODO check parameters
    	try {
			customerDb.create(new Customer(id, fname, lname, email, address, phoneNumber));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return true;

    }
    
    public boolean removeCustomer(int id) {
    	//TODO check parameters 
    	try {
			customerDb.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return true;
    }
    
    public List<Customer> getAll() {
        List<Customer> sl = null;
        try {
			sl = customerDb.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sl;

    }

    public boolean updateCustomer(int id) {
        try {
            Customer oldCustomer = customerDb.findById(id);
			customerDb.update(oldCustomer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return true;
    }
}