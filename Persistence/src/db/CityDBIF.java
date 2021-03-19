package db;

import java.sql.SQLException;
import java.util.List;

import model.City;

public interface CityDBIF {
	
	 City create(City city) throws SQLException;
	 
	 City update(City city) throws SQLException;
	 
	 boolean delete(int zip) throws SQLException;
	 
	 City findByZip(int zip) throws SQLException;
	 
	 List<City> findByName(String name) throws SQLException;
	 
	 List<City> getAll() throws SQLException;
}