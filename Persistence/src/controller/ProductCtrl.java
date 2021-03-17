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
public class ProductCtrl
{
    private ProductDB productDb;

    public ProductCtrl()
    {
        productDb = new ProductDB();
    }
    
    public boolean addProduct(int id, String name, String countryOfOrigin, int stock, int minStock, String productType) {
 
    	//TODO check parameters
    	try {
			productDb.create(new Product(id, name, countryOfOrigin, stock, minStock, productType));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return true;

    }
    
    public boolean removeProduct(int id) {
    	//TODO check parameters 
    	try {
			productDb.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return true;
    }
    
    public List<Product> getAll() {
        List<Product> sl = null;
        try {
			sl = productDb.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sl;

    }

    public boolean updateCustomer(int id) {
        try {
            Product oldProduct = productDb.findById(id);
			productDb.update(oldProduct);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return true;
    }
}
