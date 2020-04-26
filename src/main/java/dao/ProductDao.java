package dao;

import java.sql.*;

import database.dbConnect;

public class ProductDao implements Dao<Product>{
	
	private Statement stmt;
	
	public ProductDao(dbConnect db) {
		this.stmt = db.createStatement();
	}

	public void Create(Product product) {
		// TODO Auto-generated method stub
		String sqlInsert = "Insert into Products values("+product.getID()+",'"+ product.getName()+ "',"
				+ product.getPrice()+ ","+ product.getStock()+")";
				
				try {
					stmt.executeUpdate(sqlInsert);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	public void Read() {
		// TODO Auto-generated method stub
		
		String sql2 = "SELECT * from Products";
		ResultSet rs = null;
		
		try {
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while(rs.next()) {
				int id1 = rs.getInt("product_id");
				String name1 = rs.getString("name");
				double price = rs.getDouble("price");
				int stock = rs.getInt("stock");
				System.out.println("id: "+id1+ " |name: "+name1+" |price: "+ price+ " |stock: "+stock);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void Update(Product t) {
		// TODO Auto-generated method stub
		
	}

	public void Delete(int id) {
		// TODO Auto-generated method stub
		String sql4 = "DELETE FROM Products where product_id= " + id;
		try {
			stmt.executeUpdate(sql4);
			System.out.println("Deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	

}
