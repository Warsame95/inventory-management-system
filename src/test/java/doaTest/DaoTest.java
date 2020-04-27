package doaTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import dao.Customer;
import dao.CustomerDao;
import database.dbConnect;

public class DaoTest {
	
	@Test
	public void CustomerDaoTest() {
		dbConnect db = new dbConnect("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/gamedb?useSSL=false","root","Manchester95");
		CustomerDao cd = mock(CustomerDao.class);
		Customer MockCustomer = mock(Customer.class);
		
		verify(cd).Create(MockCustomer);
	}

}
