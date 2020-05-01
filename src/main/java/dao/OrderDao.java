package dao;

import java.sql.*;
import java.util.ArrayList;

import database.dbConnect;
import domains.Order;
import domains.Product;

public class OrderDao implements Dao<Order>{
	
	private Statement stmt;
	
	public OrderDao(dbConnect db) {
		this.stmt = db.createStatement();
	}
 
	public Order Create(Order order) {
		// TODO Auto-generated method stub
		double totalPrice = getPrice(order.getProductId())*order.getQuantity();
		
		String sqlInsert = "Insert into orders (product_id, customer_id, quantity, price) values("+ order.getProductId()+ ","
				+ order.getCustomerId()+ ","+ order.getQuantity()+","+ totalPrice +")";
				
				try {
					stmt.executeUpdate(sqlInsert);
					return readLatest();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return null;
	}

	
	
	public ArrayList<Order> Read() {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM orders");
			ArrayList<Order> orders = new ArrayList<Order>();
			while(rs.next()) {
				orders.add(getOrder(rs));
			}
			return orders;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Order>();
	}

	public Order Update(int id, String attribute, Order order) {
		// TODO Auto-generated method stub
		Order o;
		String sql = "";
		String sql2 = "";
		switch(attribute) {
		case "PRODUCTID":
			sql = "UPDATE orders set product_id = "+ order.getProductId() + " where order_id = "+id;
			break;
		case "CUSTOMERID":
			sql = "UPDATE orders set customer_id = "+ order.getCustomerId() + " where order_id = "+id;
			break;
		case "PRICE":
			sql = "UPDATE orders set price = "+ order.getPrice() + " where order_id = "+id;
			break;
		case "QUANTITY":
			sql = "UPDATE orders set quantity = "+ order.getQuantity() + " where order_id = "+id;
			o = readById(id);
			double price = getPrice(o.getProductId())*order.getQuantity();
			sql2 = "UPDATE orders set price = "+ price + " where order_id = "+id;
			break;
		}
		
		try {
			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql2);
			return readById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void Delete(int order_id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM orders where order_id= " + order_id;
		try {
			stmt.executeUpdate(sql);
			System.out.println("Deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Order getOrder(ResultSet rs) throws SQLException {
		int ID = rs.getInt("order_id");
		int prodID = rs.getInt("product_id");
		int cusID = rs.getInt("customer_id");
		int quantity = rs.getInt("quantity");
		double price = rs.getDouble("price");
		
		return new Order(ID,prodID,cusID,quantity,price);
	}
	
	public Order readLatest() {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM orders order by order_id limit 1");
			rs.next();
			return getOrder(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Order readById(int ID) {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM orders where order_id = "+ID);
			rs.next();
			return getOrder(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Double getPrice(int productID) {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM products where product_id = "+productID);
			rs.next();
			double price = rs.getDouble("price");
			return price;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
