package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.SaleOrder;
import controller.SaleOrderCtrl;

public class SaleOrderDB implements SaleOrderDBIF {
	
//	SaleOrderCtrl sCtrl = new SaleOrderCtrl();
//	public List<SaleOrder> getAll() throws SQLException {
//		String sql = "select * from SaleOrder";
//		try (Statement s = DBConnection.getInstance().getDBcon().createStatement()){
//			ResultSet rs = s.executeQuery(sql);
//			List<SaleOrder> res = buildObjects(rs);
//			return res;
//		} 
//		catch (SQLException e) {
//			e.printStackTrace();
//			throw e;
//		}
//	}
	
	public SaleOrder create(SaleOrder s) throws SQLException {
		String sql = String.format("insert into SaleOrder (saleDate, amount, deliveryStatus, deliveryDate, customer_Id, invoice_invoiceNo) values (%s, %s, %s, %s, %s, %s)", s.getDate(), s.getAmount(), s.getDeliveryStatus(), s.getDeliveryDate(), s.getCustomer(), s.getInvoice());
		//note: rename in database SaleDate to saleDate if possible dont use CamelCase but camel_case
		DBConnection.getInstance().executeUpdate(sql);
		return s;
	}
	public int findLastId() throws SQLException {
		int lastId = 150;
		String sql = "Select top 1 id from SaleOrder order by id desc;";
		System.out.println("ProductDb, Query: " + sql);
		try(Statement s = DBConnection.getInstance().getDBcon().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				
				lastId = rs.getInt("id");	
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}		
		
		return lastId;
	}
	
	public SaleOrder update(SaleOrder s) throws SQLException {
		String sql = "update SaleOrder set "
				+ "saledate='" + s.getDate() + "'"
				+ ", amount=" + s.getAmount() + ""
				+ ", deliveryStatus='" + s.getDeliveryStatus() + "'"
				+ ", deliveryDate='" + s.getDeliveryDate() + "'"
				+ ", customer_id=" + s.getCustomer() + ""
				+ ", invoice_invoiceNo=" + s.getInvoice() + ""
				+ " where id = " + s.getId() + "";
		int res = DBConnection.getInstance().executeUpdate(sql);
		return res == 1 ? s : null;
	}

	public boolean delete(int id) throws SQLException {
		String sql = "delete from SaleOrder where id = " + id;
		int res = DBConnection.getInstance().executeUpdate(sql);
		return res > 0;
	}}
	
//	public SaleOrder findById(int id) throws SQLException {
//		SaleOrder res = null;
//		String sql = "select * from SaleOrder where id = " + id;
//		System.out.println("SaleOrderDb, Query: " + sql);
//		try(Statement s = DBConnection.getInstance().getDBcon().createStatement()) {
//			ResultSet rs = s.executeQuery(sql);
//			if(rs.next()) {
//				res = buildObject(rs);
//			}
//		} 
//		catch (SQLException e) {
//			e.printStackTrace();
//			throw e;
//		}
//		return res;				
//	}
////	
//	public List<SaleOrder> findByName(String name) throws SQLException {
//		List<SaleOrder> res = new ArrayList<>();
//		
//		String sql = "select * from SaleOrder where name like '%" + name + "%'";
//		System.out.println("SaleOrderDb, Query: " + sql);
//		try(Statement s = DBConnection.getInstance().getDBcon().createStatement()) {
//			ResultSet rs = s.executeQuery(sql);
//			res = buildObjects(rs);
//		} 
//		catch (SQLException e) {
//			e.printStackTrace();
//			throw e;
//		}		
//		return res;
//	}
//	
//	private List<SaleOrder> buildObjects(ResultSet rs) throws SQLException {
//		ArrayList<SaleOrder> res = new ArrayList<>();
//		while(rs.next()) {
//			SaleOrder b = buildObject(rs);
//			res.add(b);
//		}
//		return res;
//	}

//	private SaleOrder buildObject(ResultSet rs) throws SQLException {
//		SaleOrder b = null;
//		b = new SaleOrder(rs.getInt("id"),rs.getTimestamp("Saledate"),rs.getDouble("amount"),rs.getString("deliveryStatus"),rs.getDate("deliveryDate"), rs.getInt("customer_id"), rs.getInt("invoice_invoiceNo"));
//		return b;
//	}
//}