package dao;


import database.dbConnect;
import domains.Customer;
import utils.Utils;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDao implements Dao<Customer> {
	Statement stmt = null;
	
	public CustomerDao(dbConnect db) {
		this.stmt = db.createStatement();

	}
	
	public Customer Create(Customer customer) {
		// TODO Auto-generated method stub
		String sqlInsert = "Insert into customers (name, email, address) values('" + customer.getName()+ "','"
		+ customer.getEmail()+ "','"+ customer.getAddress()+"')";
		
		try {
			stmt.executeUpdate(sqlInsert);
			return readLatest();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public ArrayList<Customer> Read() {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
			ArrayList<Customer> customers = new ArrayList<Customer>();
			while(rs.next()) {
				customers.add(getCustomer(rs));
			}
			return customers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Customer>();
	}



	public Customer Update(int id, String attribute, Customer customer) {
		// TODO Auto-generated method stub
		
		String sql = "";
		
		switch(attribute) {
		case "NAME":
			sql = "UPDATE customers set name = '"+ customer.getName() + "' where customer_id = "+id;
			break;
		case "EMAIL":
			sql = "UPDATE customers set email = '"+ customer.getEmail() + "' where customer_id = "+id;
			break;
		case "ADDRESS":
			sql = "UPDATE customers set address = '"+ customer.getAddress() + "' where customer_id = "+id;
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
		String sql4 = "DELETE FROM customers where customer_id= " + id;
		try {
			stmt.executeUpdate(sql4);
			System.out.println("Deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Customer readLatest() {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM customers order by customer_id limit 1");
			rs.next();
			return getCustomer(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Customer getCustomer(ResultSet rs) throws SQLException {
		int ID = rs.getInt("customer_id");
		String name = rs.getString("name");
		String email = rs.getString("email");
		String address = rs.getString("address");
		
		return new Customer(ID,name,email,address);
	}
	
	public Customer readById(int ID) {
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM customers where customer_id = "+ID);
			rs.next();
			return getCustomer(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

}
