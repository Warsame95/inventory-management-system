package ims;

import Controllers.CustomerController;
import Controllers.ProductController;
import Services.CustomerService;
import Services.ProductService;
import dao.*;
import database.dbConnect;

public class Main {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/gamedb?useSSL=false";
	static final String USER = "root";
	static final String PASS = "Manchester95";
	
	public static void main(String[] args) {
		
		
		dbConnect db = new dbConnect(JDBC_DRIVER, DB_URL, USER, PASS);
		
		//customer
		
		CustomerController cc = new CustomerController(new CustomerService(new CustomerDao(db)));
		cc.Create();
		
		
		
		
	}

}
