package ServicesTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import Services.CustomerService;
import dao.CustomerDao;
import domains.Customer;

public class CustomerServiceTest {
	
	CustomerDao customerDao = mock(CustomerDao.class);
	Customer customer = mock(Customer.class);
	
	@Test
	public void Create() {
		CustomerService customerService = new CustomerService(customerDao);
		customerService.Create(customer);
		verify(customerDao, times(1)).Create(customer);
	}
	
	@Test
	public void Read() {
		CustomerService customerService = new CustomerService(customerDao);
		customerService.Read();
		verify(customerDao, times(1)).Read();
	}
	
	
	
	@Test
	public void Update() {
		CustomerService customerService = new CustomerService(customerDao);
		customerService.Update(2, "Name", customer);
		verify(customerDao, times(1)).Update(2,"Name",customer);
	}
	
	@Test
	public void Delete() {
		CustomerService customerService = new CustomerService(customerDao);
		customerService.Delete(0);
		verify(customerDao, times(1)).Delete(0);
	}
}
