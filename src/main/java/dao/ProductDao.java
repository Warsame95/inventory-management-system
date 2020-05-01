package dao;

import java.sql.*;
import java.util.ArrayList;

import database.dbConnect;
import domains.Customer;
import domains.Product;

public class ProductDao implements Dao<Product>{
	
	private Statement stmt;
	
	public ProductDao(dbConnect db) {
		this.stmt = db.createStatement();
	}

	public Product Create(Product product) {
		// TODO Auto-generated method stub
		String sqlInsert = "Insert into products (name, price, stock) values('"+ product.getName()+ "',"
				+ product.getPrice()+ ","+ product.getStock()+")";
				
				try {
					stmt.executeUpdate(sqlInsert);
					return readLatest();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return null;
	}

	
	public ArrayList<Product> Read() {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM products");
			ArrayList<Product> products = new ArrayList<Product>();
			while(rs.next()) {
				products.add(getProduct(rs));
			}
			return products;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Product>();
	}

	public Product Update(int id, String attribute, Product product) {
		// TODO Auto-generated method stub
		String sql = "";
		
		switch(attribute) {
		case "NAME":
			sql = "UPDATE products set name = '"+ product.getName() + "' where product_id = "+id;
			break;
		case "PRICE":
			sql = "UPDATE products set price = "+ product.getPrice() + " where product_id = "+id;
			break;
		case "STOCK":
			sql = "UPDATE products set stock = "+ product.getStock() + " where product_id = "+id;
			break;
		}
		
		try {
			stmt.executeUpdate(sql);
			return readById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public void Delete(int id) {
		// TODO Auto-generated method stub
		String sql4 = "DELETE FROM products where product_id= " + id;
		try {
			stmt.executeUpdate(sql4);
			System.out.println("Deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Product getProduct(ResultSet rs) throws SQLException {
		int ID = rs.getInt("product_id");
		String name = rs.getString("name");
		double price = rs.getDouble("price");
		int stock = rs.getInt("stock");
		
		return new Product(ID,name,price,stock);
	}
	
	public Product readLatest() {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM products order by product_id limit 1");
			rs.next();
			return getProduct(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Product readById(int ID) {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM products where product_id = "+ID);
			rs.next();
			return getProduct(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
		
	

}
