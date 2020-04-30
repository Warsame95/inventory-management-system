package ControllersTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;

import Controllers.OrderController;
import Services.OrderService;
import domains.Order;
import domains.Product;
import utils.Utils;

public class OrderControllerTest {
	
	OrderService orderService = mock(OrderService.class);
	Utils utils = mock(Utils.class);
	
	@Test
	public void CreateTest() {
		
		when(utils.getInt()).thenReturn(2).thenReturn(23).thenReturn(30);
		
		OrderController orderController = new OrderController(orderService, utils);
		Order returnedOrder = new Order(23,4,50);
		
		assertEquals(returnedOrder.getProductId(), orderController.Create().getProductId());
	}
	
	@Test
	public void ReadTest() {
		OrderController orderController = new OrderController(orderService, utils);
		ArrayList<Order> orders = new ArrayList<>();
		
		orders.add(new Order(23,5,30));
		orders.add(new Order(46,9,15));
		
		when(orderService.Read()).thenReturn(orders);
		assertEquals(orders,orderController.Read());
	}
	
	@Test
	public void UpdateTest() {
		OrderController orderController = new OrderController(orderService, utils);
		
		when(utils.getInt()).thenReturn(2).thenReturn(20);
		when(utils.getInput()).thenReturn("quantity");
		
		Order orderReturned = new Order(2, 0, 0, 20);
		assertEquals(orderReturned.getQuantity(), orderController.Update().getQuantity());
	}
	
	@Test
	public void DeleteTest() {
		OrderController orderController = new OrderController(orderService, utils);
		orderController.Delete();
		verify(orderService, times(1)).Delete(0);
	}

}
