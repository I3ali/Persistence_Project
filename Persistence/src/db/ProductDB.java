package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDB implements ProductDBIF{

	public List<Product> getAll() throws SQLException {
		String sql = "select * from Product";
		try (Statement s = DBConnection.getInstance().getDBcon().createStatement()){
			ResultSet rs = s.executeQuery(sql);
			List<Product> res = buildObjects(rs);
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public Product create(Product product) throws SQLException {
		String sql = String.format("insert into Product (name, countryOfOrigin, stock, minStock, productType) values ('%s', '%s', '%s', '%s', '%s')", product.getName(), product.getCountryOfOrigin(), product.getStock(), product.getMinStock(), product.getProductType());
		DBConnection.getInstance().executeUpdate(sql);
		return product;
	}
	
	public Product update(Product product) throws SQLException {
		String sql = "update Product set "
				+ "id='" + product.getId() + "'"
				+ "name='" + product.getName() + "'"
				+ "countryOfOrigin='" + product.getCountryOfOrigin() + "'"
				+ "stock='" + product.getStock() + "'"
				+ "minStock='" + product.getMinStock() + "'"
				+ "productType='" + product.getProductType() + "'"
				+ "where id = " + product.getId() + "";
		int res = DBConnection.getInstance().executeUpdate(sql);
		return res == 1 ? product : null;
	}

	public boolean delete(int id) throws SQLException {
		String sql = "delete from Product where id = " + id;
		int res = DBConnection.getInstance().executeUpdate(sql);
		return res > 0;
	}

	public Product findById(int id) throws SQLException {
		Product res = null;
		String sql = "select * from Product where id = " + id;
		System.out.println("ProductDb, Query: " + sql);
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

	public List<Product> findByName(String name) throws SQLException {
		List<Product> res = new ArrayList<>();
		
		String sql = "select * from Product where name like '%" + name + "%'";
		System.out.println("ProductDb, Query: " + sql);
		try(Statement s = DBConnection.getInstance().getDBcon().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			res = buildObjects(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}		
		return res;
	}
	
	public float getPriceById(int id) throws SQLException{
		float price = 2;
		String sql = "Select top 1 price from Price where product_id = "+ id +" order by startDate desc;";
		System.out.println("ProductDb, Query: " + sql);
		try(Statement s = DBConnection.getInstance().getDBcon().createStatement()) {
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				
				price = rs.getFloat("price");	
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}		
		
		return price;
	}

	
	
	private List<Product> buildObjects(ResultSet rs) throws SQLException {
		ArrayList<Product> res = new ArrayList<>();
		while(rs.next()) {
			Product b = buildObject(rs);
			res.add(b);
		}
		return res;
	}
		
	private Product buildObject(ResultSet rs) throws SQLException {
		Product b = null;
		b = new Product(rs.getInt("id"),rs.getString("name"),rs.getString("countryOfOrigin"),rs.getInt("stock"),rs.getInt("minStock"),rs.getString("productType") );
		return b;
	}
}