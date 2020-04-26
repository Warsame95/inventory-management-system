package dao;

import java.sql.*;

import com.mysql.jdbc.Statement;

import database.dbConnect;

public class OrderDao implements Dao<Order>{
	
	private Statement stmt;
	
	public OrderDao(dbConnect db) {
		
	}

	public void Create(Order order) {
		// TODO Auto-generated method stub
		
		String sqlInsert = "Insert into Orders values("+order.getOrderId()+","+ order.getProductId()+ ","
				+ order.getCustomerId()+ ","+ order.getQuantity()+ ","+ order.getPrice() +")";
				
				try {
					stmt.executeUpdate(sqlInsert);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	public void Read() {
		// TODO Auto-generated method stub
		String sql2 = "SELECT * from Orders";
		ResultSet rs = null;
		
		try {
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while(rs.next()) {
				int order_id = rs.getInt("order_id");
				int product_id = rs.getInt("product_id");
				int customer_id = rs.getInt("customer_id");
				int quantity = rs.getInt("quantity");
				double price = rs.getDouble("price");
				System.out.println("order_id: "+order_id+ " |product_id: "+product_id+" |customer_id: "+ customer_id+ " |quantity: "+quantity+" |price: "+price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void Update(Order order) {
		// TODO Auto-generated method stub
		
	}

	public void Delete(int order_id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Orders where order_id= " + order_id;
		try {
			stmt.executeUpdate(sql);
			System.out.println("Deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
