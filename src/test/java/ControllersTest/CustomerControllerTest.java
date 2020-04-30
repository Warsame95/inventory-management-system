package ControllersTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;

import Controllers.CustomerController;
import Services.CustomerService;
import domains.Customer;
import utils.Utils;

public class CustomerControllerTest {
	
	@Test
	public void CreateTest() {
		CustomerService customerService = mock(CustomerService.class);
		Utils utils = mock(Utils.class);
		CustomerController customerController = new CustomerController(customerService, utils);
		
		when(utils.getInput()).thenReturn("john");
		when(utils.getInput()).thenReturn("john@gmail.com");
		//when(utils.getInput()).thenReturn("123 high road");
		Customer returnedCustomer = new Customer("john", "john@gmail.com", "123 high road");
		
		//when(customerService.Create(customer)).thenReturn(returnedCustomer);
		assertEquals(returnedCustomer, customerController.Create());
	}
	
//	@Test
//	public void ReadTest() {
//		CustomerService customerService = mock(CustomerService.class);
//		Utils utils = mock(Utils.class);
//		CustomerController customerController = new CustomerController(customerService,utils);
//		
//		ArrayList<Customer> customers = new ArrayList<>();
//		customers.add(new Customer("Chris", "P","123 high road"));
//		customers.add(new Customer("Rhys", "T","456 high road"));
//		customers.add(new Customer("Nic", "J", "789 high road"));
//		
//		when(customerService.Read()).thenReturn(customers);
//		
//		assertEquals(customers, customerController.Read());
//	}
	
//	@Test
//	public void UpdateTest() {
//		CustomerService customerService = mock(CustomerService.class);
//		CustomerController customerController = new CustomerController(customerService);
//		
//		when(customerService.Read()).
//	}
//	
//	public void DeleteTest() {
//		
//	}
	
	
}
