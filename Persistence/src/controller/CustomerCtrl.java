package controller;

import java.sql.SQLException;
import java.util.List;

import model.*;
import db.*;

public class CustomerCtrl {
    private CustomerDB customerDb;

    public CustomerCtrl() {
        customerDb = new CustomerDB();
    }

    public boolean addCustomer(int id, String fname, String lname, String email, String address, String phoneNumber, int zipcode) {
    	try {
			customerDb.create(new Customer(id, fname, lname, email, address, phoneNumber, zipcode));
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return true;
    }
    
    public boolean removeCustomer(int id) {
    	try {
			customerDb.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return true;
    }
    
    public List<Customer> getAll() {
        List<Customer> cl = null;
        try {
			cl = customerDb.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cl;

    }

    public boolean updateCustomer(int id, Customer newCustomer) {
        try {
        	newCustomer.setId(id);
			customerDb.update(newCustomer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return true;
    }

	
	public boolean findById(int id) {
        try {
			customerDb.findById(id);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public List<Customer> findByName(String name) {
        List<Customer> cl2 = null;
        try {
			cl2 = customerDb.findByName(name);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return cl2;
	}   
}