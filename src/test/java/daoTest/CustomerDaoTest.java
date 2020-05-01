package daoTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;


import dao.CustomerDao;
import dao.Dao;
import database.dbConnect;
import domains.Customer;

public class CustomerDaoTest {
	
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/gamedbtest?useSSL=false";
	static final String USER = "root";
	static final String PASS = "Manchester95";
	
	dbConnect db;
	Statement stmt = null;
	Connection conn = null;
	Dao customerDao;
	
	@Before
	public void init() {
		db = new dbConnect(JDBC_DRIVER, DB_URL, USER, PASS);
		stmt = db.createStatement();
		
		customerDao = new CustomerDao(db);
	}
	
	@Test
	public void testCreate() {
		
		//Dao customerDao = new CustomerDao(db);
		
		Customer cus = mock(Customer.class);
		Customer cus1 = mock(Customer.class);
		
		customerDao.Create(cus);
		customerDao.Create(cus1);
		
		ResultSet rs = null;
		String name = null;
		int num = 0;
		
		try {
			rs = stmt.executeQuery("Select count(*) from customers");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.next();
			num = rs.getInt("count(*)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		assertEquals(2, num);
		
		try {
			stmt.executeUpdate("delete from customers");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void testUpdate() {

		Customer cus = mock(Customer.class);
		
		when(cus.getName()).thenReturn("Warsame");
		
		//customerDao.Update(1, "NAME", cus);
		
		
		
			
		
	}
	
//	@Test
//	public void testDelete() {
//		
//		Customer cus = mock(Customer.class);
//		Customer cus1 = mock(Customer.class);
//		when(cus.getID()).thenReturn(1);
//		when(cus1.getID()).thenReturn(2);
//		
//		customerDao.Create(cus);
//		customerDao.Create(cus1);
//		customerDao.Delete(1);
//		
//		ResultSet rs = null;
//		int num = 0;
//		try {
//			rs = stmt.executeQuery("Select count(*) from customers");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			rs.next();
//			num = rs.getInt("count(*)");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		assertEquals(1, num);
//		
//		try {
//			stmt.executeUpdate("delete from customers");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}

}
