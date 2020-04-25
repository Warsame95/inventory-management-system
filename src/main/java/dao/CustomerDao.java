package dao;

import java.beans.Statement;

public class CustomerDao implements Dao<Customer> {
	private Statement stmt;
	
	
	public CustomerDao(Statement stmt) {
		this.stmt = stmt;
	}

	
	public void Create(Customer customer) {
		// TODO Auto-generated method stub
		
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
