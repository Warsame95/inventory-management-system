package dao;


import database.dbConnect;
import utils.Utils;

import java.sql.*;

public class CustomerDao implements Dao<Customer> {
	Statement stmt = null;
	
	public CustomerDao(dbConnect db) {
		this.stmt = db.createStatement();

	}
	
	public void Create(Customer customer) {
		// TODO Auto-generated method stub
		String sqlInsert = "Insert into Customers values("+customer.getID()+",'"+ customer.getName()+ "','"
		+ customer.getEmail()+ "','"+ customer.getAddress()+"')";
		
		try {
			stmt.executeUpdate(sqlInsert);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void Read() {
		// TODO Auto-generated method stub

		String sql2 = "SELECT * from Customers";
		ResultSet rs = null;
		
		try {
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while(rs.next()) {
				int id1 = rs.getInt("customer_id");
				String name1 = rs.getString("name");
				String email1 = rs.getString("email");
				String address1 = rs.getString("address");
				System.out.println("id: "+id1+ " |name: "+name1+" |email: "+ email1+ " |Address: "+address1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Update(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("Enter ID of Customer you like to update.");
		int id = Utils.getInt();
		
		System.out.println("Enter the field you would like to update");
		String attribute = Utils.getInput().toUpperCase();
		
		System.out.println("Enter new value");
		String newValue = Utils.getInput();
		
		String sql = "";
		
		switch(attribute) {
		case "NAME":
			sql = "UPDATE Customers set name = '"+ newValue + "' where customer_id = "+id;
			break;
		case "EMAIL":
			sql = "UPDATE Customers set email = '"+ newValue + "' where customer_id = "+id;
			break;
		case "ADDRESS":
			sql = "UPDATE Customers set Address = '"+ newValue + "' where customer_id = "+id;
			break;
		}
		
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Delete(int id) {
		// TODO Auto-generated method stub
		String sql4 = "DELETE FROM Customers where customer_id= " + id;
		try {
			stmt.executeUpdate(sql4);
			System.out.println("Deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
