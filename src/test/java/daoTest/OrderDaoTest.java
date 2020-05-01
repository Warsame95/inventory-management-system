package daoTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

import dao.OrderDao;
import database.dbConnect;
import domains.Order;

public class OrderDaoTest {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/gamedbtest?useSSL=false";
	static final String USER = "root";
	static final String PASS = "Manchester95";
	
	dbConnect db;
	Statement stmt = null;
	
	Order order = mock(Order.class);
	
	@Before
	public void init() {
		db = new dbConnect(JDBC_DRIVER, DB_URL, USER, PASS);
		stmt = db.createStatement();
	}
	
	
	
	@Test
	public void CreateTest() {
		when(order.getCustomerId()).thenReturn(50);
		when(order.getProductId()).thenReturn(4);
		when(order.getQuantity()).thenReturn(3);
		
		OrderDao od = new OrderDao(db);
		Order returnOrder = new Order(4,50,3);
		
		assertEquals(returnOrder.getCustomerId(), od.Create(order) );
	}

}
