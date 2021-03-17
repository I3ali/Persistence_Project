package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDB {
	
	private List<Product> buildObjects(ResultSet rs) throws SQLException {
		ArrayList<Product> res = new ArrayList<>();
		while(rs.next()) {
			Product b = buildObject(rs);
			res.add(b);
		}
		return res;
	}

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
		String sql = String.format("insert into Product (id, name, countryOfOrigin, stock, minStock, productType) values ('%s', '%s', '%s', '%s', '%s', '%s')", product.getId(), product.getName(), product.getCountryOfOrigin(), product.getStock(), product.getMinStock(), product.getProductType());
		int id = DBConnection.getInstance().executeUpdate(sql);
		product.setId(id);
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
	
	private Product buildObject(ResultSet rs) throws SQLException {
		Product b = null;
		b = new Product(rs.getInt("id"),rs.getString("name"),rs.getString("countryOfOrigin"),rs.getInt("stock"),rs.getInt("minStock"),rs.getString("productType") );
		return b;
	}
}