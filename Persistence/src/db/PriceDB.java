package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Price;
import model.Product;
import controller.PriceCtrl;

public class PriceDB {

	PriceCtrl pCtrl = new PriceCtrl();

	public List<Price> getAll() throws SQLException {
		String sql = "select * from Price";
		try (Statement s = DBConnection.getInstance().getDBcon().createStatement()){
			ResultSet rs = s.executeQuery(sql);
			List<Price> res = buildObjects(rs);
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public Price create(Price price) throws SQLException {
		String sql = String.format("insert into Price (startDate, price, priceType, product) values ('%s', '%s', '%s', '%s', '%s')", price.getStartDate(), price.getPrice(), price.getPriceType(), price.getProduct());
		DBConnection.getInstance().executeUpdate(sql);
		return price;
	}
	
	public Price update(Price price) throws SQLException {
		String sql = "update Price set "
				+ "startDate='" + price.getStartDate() + "'"
				+ "price='" + price.getPrice() + "'"
				+ "priceType='" + price.getPriceType() + "'"
				+ "product='" + price.getProduct() + "'"
				+ "where product = " + price.getProduct() + "";
		int res = DBConnection.getInstance().executeUpdate(sql);
		return res == 1 ? price : null;
	}

	public boolean delete(Product product) throws SQLException {
		String sql = "delete from Price where product = " + product;
		int res = DBConnection.getInstance().executeUpdate(sql);
		return res > 0;
	}

	public Price findByProductId(Product product) throws SQLException {
		Price res = null;
		String sql = "select * from Price where product = " + product;
		System.out.println("PriceDb, Query: " + sql);
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

	public List<Price> findByPrice(Double price) throws SQLException {
		List<Price> res = new ArrayList<>();
		
		String sql = "select * from Price where price like '%" + price + "%'";
		System.out.println("PriceDb, Query: " + sql);
		try(Statement s = DBConnection.getInstance().getDBcon().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			res = buildObjects(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}		
		return res;
	}

	private List<Price> buildObjects(ResultSet rs) throws SQLException {
		ArrayList<Price> res = new ArrayList<>();
		while(rs.next()) {
			Price b = buildObject(rs);
			res.add(b);
		}
		return res;
	}
		
	private Price buildObject(ResultSet rs) throws SQLException {
		Price b = null;
		b = new Price(rs.getTimestamp("startDate"),rs.getDouble("price"),rs.getString("priceType"), pCtrl.getProductByID(rs.getInt("product_id")));
		return b;
	}
}