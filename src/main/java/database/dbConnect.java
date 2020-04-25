package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConnect {
	
	private Connection conn = null;
	private Statement stmt = null;
	

	public dbConnect(String JDBC_DRIVER, String DB_URL, String USER, String PASS) {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		System.out.println("Starting connection to db");
		
		try {
			this.conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("CONNECTION ESTABLISHED");
		
	}
	
	
	

	public Connection getConn() {
		return conn;
	}



	public void setConn(Connection conn) {
		this.conn = conn;
	}



	public Statement getStmt() {
		return stmt;
	}



	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}
	
	
	public Statement createStatement() {
		
		try {
			this.stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return stmt;
	}
	
	

}
