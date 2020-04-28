package doaTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.Connection;

import dao.Customer;
import dao.CustomerDao;
import dao.Dao;
import database.dbConnect;

public class CustomerDaoTest {
	
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/gamedbtest?useSSL=false";
	static final String USER = "root";
	static final String PASS = "Manchester95";
	
	dbConnect db;
	Statement stmt = null;
	Connection conn = null;
	
	
	@Before
	public void init() {
		db = new dbConnect(JDBC_DRIVER, DB_URL, USER, PASS);
		stmt = db.createStatement();
		assertNotNull(db.createStatement());
	}
	
	@Test
	public void testCreate() {
		
		Dao customerDao = new CustomerDao(db);
		Customer cus = mock(Customer.class);
		customerDao.Create(cus);
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
		
		assertEquals(1, num);
		
	}
	
	
	@Test
	public void testUpdate() {
		
		Dao CustomerDao = new CustomerDao(db);
		Customer cus = mock(Customer.class);
		
		CustomerDao.Update(1, "NAME", cus);
			
		
	}

}
