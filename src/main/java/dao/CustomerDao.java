package dao;


import database.dbConnect;
import java.sql.*;

public class CustomerDao implements Dao<Customer> {
	Statement stmt = null;
	
	public CustomerDao(dbConnect db) {
		this.stmt = db.createStatement();

	}
	
	public void Create(Customer customer) {
		// TODO Auto-generated method stub
		String sqlInsert = "Insert into Customers values('"+customer.getID()+"','"+ customer.getName()+ "','"
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
		
	}

	public void Update(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	public void Delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
