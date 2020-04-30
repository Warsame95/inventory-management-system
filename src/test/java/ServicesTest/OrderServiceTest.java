package ServicesTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import Services.OrderService;
import dao.OrderDao;
import domains.Order;

public class OrderServiceTest {
	
	OrderDao od = mock(OrderDao.class);
	Order order = mock(Order.class);
	
	
	@Test
	public void Create() {
		OrderService os = new OrderService(od);
		os.Create(order);
		verify(od, times(1)).Create(order);
	}
	
	@Test
	public void Read() {
		OrderService os = new OrderService(od);
		os.Read();
		verify(od, times(1)).Read();
	}
	
	@Test
	public void Update() {
		OrderService os = new OrderService(od);
		os.Update(2, "quantity", order);
		verify(od, times(1)).Update(2, "quantity", order);
	}
	
	@Test
	public void Delete() {
		OrderService os = new OrderService(od);
		os.Delete(0);
		verify(od, times(1)).Delete(0);
	}
}
