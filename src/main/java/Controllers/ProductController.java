package Controllers;

import java.util.ArrayList;

import Services.CrudService;
import domains.Order;
import domains.Product;
import utils.Utils;

public class ProductController implements CrudController<Product> {
	
	private CrudService<Product> productService;
	
	Utils utils;
	
	public ProductController(CrudService<Product> productService, Utils passedUtil) {
		this.productService = productService;
		this.utils = passedUtil;
	}

	@Override
	public Product Create() {
		// TODO Auto-generated method stub
		System.out.println("Enter ID of Products you would like to add");
		int ID = utils.getInt();
		
		System.out.println("Enter name of product");
		String name = utils.getInput();
		
		System.out.println("Enter the price of the product");
		double price = utils.getDouble();
		
		System.out.println("Enter the amount of stock of the product");
		int stock = utils.getInt();
		
		System.out.println("Product created");
		Product prodTemp = new Product(ID, name, price, stock);
		productService.Create(new Product(ID, name, price, stock));
		return prodTemp;
	}

	@Override
	public ArrayList<Product> Read() {
		// TODO Auto-generated method stub
		ArrayList<Product> products = productService.Read();
		for (Product product: products) {
			System.out.println(product.toString());
		}
		return products;
	}

	@Override
	public Product Update() {
		// TODO Auto-generated method stub
		System.out.println("Enter ID of product you want to update");
		int ID = utils.getInt();
		
		System.out.println("Enter the attribute you want to update i.e name, price or stock");
		String attribute = utils.getInput().toUpperCase();
		
		System.out.println("Enter the new value");
		String newValue = utils.getInput();
		
		switch(attribute) {
		case "NAME":
			return productService.Update(ID, attribute, new Product(ID, newValue, 0, 0));
		case "PRICE":
			return productService.Update(ID, attribute, new Product(ID,null, Double.valueOf(newValue),0));
		case "STOCK":
			return productService.Update(ID, attribute, new Product(ID,null, 0, Integer.valueOf(newValue)));
		}
		return null;
	}

	@Override
	public void Delete() {
		// TODO Auto-generated method stub
		System.out.println("Enter the ID of the Product you want to delete");
		int ID = utils.getInt();
		
		productService.Delete(ID);
	}

}
