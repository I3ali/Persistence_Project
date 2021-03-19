package controller;

import java.sql.SQLException;
import java.util.List;

import model.*;
import db.*;

public class CityCtrl {
    private CityDB cityDb;

    public CityCtrl() {
        cityDb = new CityDB();
    }
    
    public boolean addCity(int zipcode, String name) {
    	try {
			cityDb.create(new City(zipcode,name));
		} 
        catch (SQLException e) {
			e.printStackTrace();
		}
    	return true;
    }
    
    public boolean removeCity(int zipcode) {
    	try {
			cityDb.delete(zipcode);
		} 
        catch (SQLException e) {
			e.printStackTrace();
		}
    	return true;
    }
    
    public List<City> getAll() {
        List<City> cl = null;
        try {
			cl = cityDb.getAll();
		} 
        catch (SQLException e) {
			e.printStackTrace();
		}
		return cl;

    }

    public boolean updateCity(int zipcode) {
        try {
            City oldCity = cityDb.findByZip(zipcode);
			cityDb.update(oldCity);
		} 
        catch (SQLException e) {
			e.printStackTrace();
		}
    	return true;
    }

	
	public boolean findByZip(int zipcode) {
        try {
			cityDb.findByZip(zipcode);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public List<City> findByName(String name) {
        List<City> cl = null;
        try {
			cl = cityDb.findByName(name);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return cl;
	}   
}