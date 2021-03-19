package controller;

import java.sql.SQLException;
import java.util.List;

import model.*;
import db.*;

public class ProductCtrl {
    private ProductDB productDb;

    public ProductCtrl() {
        productDb = new ProductDB();
    }

	public ProductDB getProductDb() {
		return productDb;
	}

    public boolean addProduct(int id, String name, String countryOfOrigin, int stock, int minStock, String productType) {
    	try {
			productDb.create(new Product(id, name, countryOfOrigin, stock, minStock, productType));
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
    	return true;
    }
    
    public float getProductPrice(int id) {
    	float price = 1;
    	try {
			price = productDb.getPriceById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return price;
    }
    
    public boolean removeProduct(int id) {
    	try {
			productDb.delete(id);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
    	return true;
    }
    
    public List<Product> getAll() {
        List<Product> pl = null;
        try {
			pl = productDb.getAll();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return pl;
    }

    public boolean updateProduct(int id, Product newProduct) {
        try {
            newProduct.setId(id);
			productDb.update(newProduct);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
    	return true;
    }
	
	public boolean findById(int id) {
        try {
			productDb.findById(id);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}


	public List<Product> findByName(String name) {
        List<Product> pl = null;
        try {
			pl = productDb.findByName(name);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return pl;
	}   
}
