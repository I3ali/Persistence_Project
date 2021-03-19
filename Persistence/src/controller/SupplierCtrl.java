package controller;

import java.sql.SQLException;
import java.util.List;

import model.*;
import db.*;

public class SupplierCtrl {
	private SupplierDB supplierDb;
	
	public SupplierCtrl() {
		supplierDb = new SupplierDB();
	}
	
	public SupplierDB getSupplierDB() {
		return supplierDb;
	}
	
	public boolean addSupplier(int id, String name, String address, String country, String phoneno, String email, int zipcode){
		try {
			supplierDb.create(new Supplier(id, name, address, country, phoneno, email, zipcode));
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return true;
	}
	
	public boolean removeSupplier(int id){
		try {
			supplierDb.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return true;
	}
	
	 public List<Supplier> getAll() {
        List<Supplier> cl = null;
        try {
			cl = supplierDb.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cl;

    }

	 public boolean updateSupplier(int id, Supplier newSupplier) {
        try {
        	newSupplier.setId(id);
			supplierDb.update(newSupplier);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return true;
    }

	public boolean findById(int id) {
        try {
			supplierDb.findById(id);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public List<Supplier> findByName(String name) {
        List<Supplier> cl2 = null;
        try {
			cl2 = supplierDb.findByName(name);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return cl2;
	}   
}
