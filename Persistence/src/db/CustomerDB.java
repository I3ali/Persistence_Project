package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Customer;

public class CustomerDB implements CustomerDBIF {
	
	public List<Customer> getAll() throws SQLException {
		String sql = "select * from Customer";
		try (Statement s = DBConnection.getInstance().getDBcon().createStatement()){
			ResultSet rs = s.executeQuery(sql);
			List<Customer> res = buildObjects(rs);
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public Customer create(Customer customer) throws SQLException {
		String sql = String.format("insert into Customer (id, fname, lname, email, address, phoneno) values ('%s', '%s', '%s', '%s', '%s', '%s')", customer.getId(), customer.getFname(), customer.getLname(), customer.getEmail(), customer.getAddress(), customer.getPhoneNumber());
		int id = DBConnection.getInstance().executeUpdate(sql);
		customer.setId(id);
		return customer;
	}

	public Customer update(Customer customer) throws SQLException {
		String sql = "update Customer set "
				+ "fname='" + customer.getFname() + "'"
                + "lname='" + customer.getLname() + "'"
                + "email='" + customer.getEmail() + "'"
                + "address='" + customer.getAddress() + "'"
                + "phoneno='" + customer.getPhoneNumber() + "'"
				+ "where id = " + customer.getId() + "";
		int res = DBConnection.getInstance().executeUpdate(sql);
		return res == 1 ? customer : null;
	}

	public boolean delete(int id) throws SQLException {
		String sql = "delete from Customer where id = " + id;
		int res = DBConnection.getInstance().executeUpdate(sql);
		return res > 0;
	}
	
	public Customer findById(int id) throws SQLException {
		Customer res = null;
		String sql = "select * from Customer where id = " + id;
		System.out.println("CustomerDb, Query: " + sql);
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
	
	public List<Customer> findByName(String name) throws SQLException {
		List<Customer> res = new ArrayList<>();
		
		String sql = "select * from Customer where name like '%" + name + "%'";
		System.out.println("CustomerDb, Query: " + sql);
		try(Statement s = DBConnection.getInstance().getDBcon().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			res = buildObjects(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}		
		return res;
	}
	
	private List<Customer> buildObjects(ResultSet rs) throws SQLException {
		ArrayList<Customer> res = new ArrayList<>();
		while(rs.next()) {
			Customer b = buildObject(rs);
			res.add(b);
		}
		return res;
	}

	private Customer buildObject(ResultSet rs) throws SQLException {
		Customer b = null;
		b = new Customer(rs.getInt("id"),rs.getString("fname"),rs.getString("lname"),rs.getString("email"),rs.getString("address"),rs.getString("phoneno") );
		return b;
	}
}