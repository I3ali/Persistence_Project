package controller;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import model.*;
import db.*;

import controller.ProductCtrl;

public class PriceCtrl {
    private PriceDB priceDb;
    private ProductCtrl pCtrl;

    public PriceCtrl() {
        priceDb = new PriceDB();
        pCtrl = new ProductCtrl();
    }

	public Product getProductByID(int id) {
        Product p = null;
        try {
			p = pCtrl.getProductDb().findById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
    } 

    public boolean addPrice(Timestamp startDate, double price, String priceType, Product product) {
    	try {
			priceDb.create(new Price(startDate, price, priceType, product));
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
    	return true;
    }
    
    public boolean removePrice(Product product) {
    	try {
			priceDb.delete(product);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
    	return true;
    }
    
    public List<Price> getAll() {
        List<Price> pl = null;
        try {
			pl = priceDb.getAll();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return pl;
    }

    public boolean updatePrice(Product product) {
        try {
            Price oldPrice = priceDb.findByProductId(product);
			priceDb.update(oldPrice);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
    	return true;
    }
	
	public boolean findByProductId(Product product) {
        try {
			priceDb.findByProductId(product);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}


	public List<Price> findByPrice(Double price) {
        List<Price> pl = null;
        try {
			pl = priceDb.findByPrice(price);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return pl;
	}   
}