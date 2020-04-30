package ControllersTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;

import Controllers.ProductController;
import Services.ProductService;
import domains.Customer;
import domains.Product;
import utils.Utils;

public class ProductControllerTest {
	
	ProductService productService = mock(ProductService.class);
	Utils utils = mock(Utils.class);
	
	@Test
	public void CreateTest() {
		
		when(utils.getInt()).thenReturn(2).thenReturn(5);
		when(utils.getInput()).thenReturn("gta5");
		when(utils.getDouble()).thenReturn(40.0);
		
		ProductController productController = new ProductController(productService, utils);
		Product returnedProduct = new Product(2,"gta5",40.0, 5);
		
		assertEquals(returnedProduct.getName(), productController.Create().getName());
	}
	
	@Test
	public void ReadTest() {
		ProductController productController = new ProductController(productService, utils);
		ArrayList<Product> products = new ArrayList<>();
		
		products.add(new Product(1, "gta5", 40.0, 20));
		products.add(new Product(2, "fifa20", 40.0, 40));
		
		when(productService.Read()).thenReturn(products);
		
		assertEquals(products, productController.Read());
		
	}
	
	@Test
	public void UpdateTest() {
		
		ProductController productController = new ProductController(productService, utils);
		
		when(utils.getInt()).thenReturn(2);
		when(utils.getInput()).thenReturn("name").thenReturn("warzone");
		
		Product returnedProduct = new Product(2,"warzone",40.0, 5);
		assertEquals(returnedProduct.getName(), productController.Update().getName());
	}
	
	@Test
	public void DeleteTest() {
		
		ProductController productController = new ProductController(productService, utils);
		productController.Delete();
		verify(productService,times(1)).Delete(0);
		
	}
	
	
}
