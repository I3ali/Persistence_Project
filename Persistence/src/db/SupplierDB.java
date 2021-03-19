package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.Supplier;

public class SupplierDB implements SupplierDBIF {
	
	public List<Supplier> getAll() throws SQLException {
		String sql = "select * from Supplier";
		try (Statement s = DBConnection.getInstance().getDBcon().createStatement()){
			ResultSet rs = s.executeQuery(sql);
			List<Supplier> res = buildObjects(rs);
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public Supplier create(Supplier supplier) throws SQLException {
		String sql = String.format("insert into Supplier (name, address, country, phoneno, email, city_zipcode) values ('%s', '%s', '%s', '%s', '%s','%s')", supplier.getName(), supplier.getAddress(), supplier.getCountry(), supplier.getPhoneno(), supplier.getEmail(), supplier.getZipCode());
		DBConnection.getInstance().executeUpdate(sql);
		return supplier;
	}
	
	public Supplier update(Supplier supplier) throws SQLException {
		String sql = "update Supplier set"
				+ "id=" + supplier.getId() + " "
				+ "name=" + supplier.getName() + " "
				+ "address=" + supplier.getAddress() + " "
				+ "country=" + supplier.getCountry() + " "
				+ "phoneno=" + supplier.getPhoneno() + " "
				+ "email=" + supplier.getEmail() + " ";
				//+ "where id=" supplier.getId() + " "
		int res = DBConnection.getInstance().executeUpdate(sql);
		return res == 1 ? supplier : null;
	}
	
	public boolean delete(int id) throws SQLException {
		String sql = "delete from Supplier where id = " + id;
		int res = DBConnection.getInstance().executeUpdate(sql);
		return res > 0;
	}
	
	public Supplier findById(int id) throws SQLException {
		Supplier res = null;
		String sql = "select * from Supplier where id = " + id;
		System.out.println("SupplierDb, Query: " + sql);
		try(Statement s = DBConnection.getInstance().getDBcon().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			if(rs.next()) {
				res = buildObject(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return res;				
	}
	
	public List<Supplier> findByName(String name) throws SQLException {
		List<Supplier> res = new ArrayList<>();
		
		String sql = "select * from Supplier where name like '%" + name + "%'";
		System.out.println("SupplierDb, Query: " + sql);
		try(Statement s = DBConnection.getInstance().getDBcon().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			res = buildObjects(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}		
		return res;
		}
		
	private List<Supplier> buildObjects(ResultSet rs) throws SQLException {
		ArrayList<Supplier> res = new ArrayList<>();
		while(rs.next()) {
			Supplier b = buildObject(rs);
			res.add(b);
		}
		return res;
	}
		
	private Supplier buildObject(ResultSet rs) throws SQLException {
		Supplier b = null;
		b = new Supplier(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("address"), rs.getString("country"), rs.getString("phoneno"), rs.getInt("city_zipcode"));
		return b;
	}
	
	
}