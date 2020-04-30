package ServicesTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import Services.ProductService;
import dao.ProductDao;
import domains.Product;

public class ProductServiceTest {
	
	ProductDao pd = mock(ProductDao.class);
	Product product = mock(Product.class);
	
	@Test
	public void Create() {
		ProductService ps = new ProductService(pd);
		ps.Create(product);
		verify(pd, times(1)).Create(product);
	}
	
	@Test
	public void Read() {
		ProductService ps = new ProductService(pd);
		ps.Read();
		verify(pd, times(1)).Read();
	}
	
	@Test
	public void Update() {
		ProductService ps = new ProductService(pd);
		ps.Update(2, "name", product);
		verify(pd, times(1)).Update(2, "name", product);
	}
	
	@Test
	public void Delete() {
		ProductService ps = new ProductService(pd);
		ps.Delete(0);
		verify(pd, times(1)).Delete(0);
	}
}
