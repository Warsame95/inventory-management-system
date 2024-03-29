package ControllersTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mockito;

import Controllers.CustomerController;
import Services.CustomerService;
import database.dbConnect;
import domains.Customer;
import utils.Utils;

public class CustomerControllerTest {
	
	
	@Test
	public void CreateTest() {
		CustomerService customerService = mock(CustomerService.class);
		Utils utils = mock(Utils.class);
		
		when(utils.getInput()).thenReturn("john").thenReturn("john@gmail.com").thenReturn("123 high road");
		
		CustomerController customerController = new CustomerController(customerService, utils);
		
		Customer returnedCustomer = new Customer("john", "john@gmail.com", "123 high road");
		
		//when(customerService.Create(customer)).thenReturn(returnedCustomer);
		assertEquals(returnedCustomer.getName(), customerController.Create().getName());
	}
	
	@Test
	public void ReadTest() {
		CustomerService customerService = mock(CustomerService.class);
		Utils utils = mock(Utils.class);
		CustomerController customerController = new CustomerController(customerService,utils);
		
		ArrayList<Customer> customers = new ArrayList<>();
		customers.add(new Customer("Chris", "P","123 high road"));
		customers.add(new Customer("Rhys", "T","456 high road"));
		customers.add(new Customer("Nic", "J", "789 high road"));
		
		when(customerService.Read()).thenReturn(customers);
		
		assertEquals(customers, customerController.Read());
	}
	
	@Test
	public void UpdateTest() {
		CustomerService customerService = mock(CustomerService.class);
		Utils utils = mock(Utils.class);
		CustomerController customerController = new CustomerController(customerService,utils);
		
		when(utils.getInt()).thenReturn(2);
		when(utils.getInput()).thenReturn("name").thenReturn("adam");
		
		Customer returnedCustomer = new Customer("adam", "john@gmail.com", "123 high road");
		assertEquals(returnedCustomer.getName(), customerController.Update().getName());
	}
	
	@Test
	public void DeleteTest() {
		CustomerService customerService = mock(CustomerService.class);
		Utils utils = mock(Utils.class);
		CustomerController customerController = new CustomerController(customerService,utils);
		customerController.Delete();
		verify(customerService,times(1)).Delete(0);
	}
	
	
}
