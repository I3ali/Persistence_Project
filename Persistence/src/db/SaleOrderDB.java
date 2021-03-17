package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.SaleOrder;


public class SaleOrderDB implements SaleOrderDBIF {
	
	
	public List<SaleOrder> getAll() throws SQLException {
		String sql = "select * from SaleOrder";
		try (Statement s = DBConnection.getInstance().getDBcon().createStatement()){
			ResultSet rs = s.executeQuery(sql);
			List<SaleOrder> res = buildObjects(rs);
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	

	public SaleOrder create(SaleOrder s) throws SQLException {
//		String sql = String.format("insert into table_students (id, name) values ('%s', '%s')", student.getId(), student.getName());
		int id = DBConnection.getInstance().executeUpdate(sql);
		s.setId(id);
		return s;
	}


	public SaleOrder update(SaleOrder s) throws SQLException {
//		String sql = "update table_students set "
//				+ "name='" + student.getName() + "'"
//				+ "where id = " + student.getId() + "";
		int res = DBConnection.getInstance().executeUpdate(sql);
		return res == 1 ? s : null;
	}


	public boolean delete(int id) throws SQLException {
//		String sql = "delete from table_students where id = " + id;
		int res = DBConnection.getInstance().executeUpdate(sql);
		return res > 0;
	}
	
	public SaleOrder findById(int id) throws SQLException {
		SaleOrder res = null;
//		String sql = "select * from table_students where id = " + id;
		System.out.println("SaleOrderDB, Query: " + sql);
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
	
	public List<SaleOrder> findByName(String name) throws SQLException {
		List<SaleOrder> res = new ArrayList<>();
		
//		String sql = "select * from table_students where name like '%" + name + "%'";
		System.out.println("SaleOrderDB, Query: " + sql);
		try(Statement s = DBConnection.getInstance().getDBcon().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			res = buildObjects(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}		
		return res;
	}
	
	
	private List<SaleOrder> buildObjects(ResultSet rs) throws SQLException {
		ArrayList<SaleOrder> res = new ArrayList<>();
		while(rs.next()) {
			SaleOrder b = buildObject(rs);
			res.add(b);
		}
		return res;
	}

	
	private SaleOrder buildObject(ResultSet rs) throws SQLException {
		SaleOrder b = null;
		b = new SaleOrder(rs.getInt("id"),rs.getTimestamp("Saledate"),rs.getDouble("amount"),rs.getString("deliveryStatus"),rs.getDate("deliveryDate"));
		return b;
	}
	
}
