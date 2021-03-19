package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.City;

public class CityDB implements CityDBIF{

	public List<City> getAll() throws SQLException {
		String sql = "select * from City";
		try (Statement s = DBConnection.getInstance().getDBcon().createStatement()){
			ResultSet rs = s.executeQuery(sql);
			List<City> res = buildObjects(rs);
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public City create(City city) throws SQLException {
		String sql = String.format("insert into City (zipcode, name) values ('%s', '%s')", city.getZipcode(), city.getName());
		DBConnection.getInstance().executeUpdate(sql);
		return city;
	}
	
	public City update(City city) throws SQLException {
		String sql = "update City set "
				+ "name='" + city.getName() + "'"
				+ "where zipcode = " + city.getZipcode() + "";
		int res = DBConnection.getInstance().executeUpdate(sql);
		return res == 1 ? city : null;
	}

	public boolean delete(int zip) throws SQLException {
		String sql = "delete from City where zipcode = " + zip;
		int res = DBConnection.getInstance().executeUpdate(sql);
		return res > 0;
	}

	public City findByZip(int zip) throws SQLException {
		City res = null;
		String sql = "select * from City where id = " + zip;
		System.out.println("CityDb, Query: " + sql);
		try(Statement s = DBConnection.getInstance().getDBcon().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			if(rs.next()) {
				res = buildObject(rs);
			}
		} 
        catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return res;				
	}

	public List<City> findByName(String name) throws SQLException {
		List<City> res = new ArrayList<>();
		
		String sql = "select * from City where name like '%" + name + "%'";
		System.out.println("CityDb, Query: " + sql);
		try(Statement s = DBConnection.getInstance().getDBcon().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			res = buildObjects(rs);
		} 
        catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}		
		return res;
	}

	private List<City> buildObjects(ResultSet rs) throws SQLException {
		ArrayList<City> res = new ArrayList<>();
		while(rs.next()) {
			City b = buildObject(rs);
			res.add(b);
		}
		return res;
	}
		
	private City buildObject(ResultSet rs) throws SQLException {
		City b = null;
		b = new City(rs.getInt("zipcode"),rs.getString("name"));
		return b;
	}
}