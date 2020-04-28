package ims;

import dao.*;
import database.dbConnect;

public class Main {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/gamedb?useSSL=false";
	static final String USER = "root";
	static final String PASS = "Manchester95";
	
	public static void main(String[] args) {
		
		
		dbConnect db = new dbConnect(JDBC_DRIVER, DB_URL, USER, PASS);
		
		Dao d = new CustomerDao(db);
		
		Customer cus = new Customer(2,"ilias","ilias@gmail.com","456 high road");
		
		//d.Create(cus);
		
		//d.Read();
		
		//d.Delete(2);
		d.Read();
		
		//d.Update(cus);
		
		d.Read();
		

		
	}

}
