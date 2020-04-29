package Controllers;

import Services.CrudService;
import domains.Order;
import domains.Product;
import utils.Utils;

public class ProductController implements CrudController {
	
	private CrudService<Product> productService;
	
	public ProductController(CrudService<Product> productService) {
		this.productService = productService;
	}

	@Override
	public void Create() {
		// TODO Auto-generated method stub
		System.out.println("Enter ID of Products you would like to add");
		int ID = Utils.getInt();
		
		System.out.println("Enter name of product");
		String name = Utils.getInput();
		
		System.out.println("Enter the price of the product");
		double price = Utils.getDouble();
		
		System.out.println("Enter the amount of stock of the product");
		int stock = Utils.getInt();
		
		productService.Create(new Product(ID, name, price, stock));
		
	}

	@Override
	public void Read() {
		// TODO Auto-generated method stub
		productService.Read();
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		System.out.println("Enter ID of product you want to update");
		int ID = Utils.getInt();
		
		System.out.println("Enter the attribute you want to update i.e name, price or stock");
		String attribute = Utils.getInput().toUpperCase();
		
		System.out.println("Enter the new value");
		String newValue = Utils.getInput();
		
		switch(attribute) {
		case "NAME":
			productService.Update(ID, attribute, new Product(ID, newValue, 0, 0));
			break;
		case "PRICE":
			productService.Update(ID, attribute, new Product(ID,null, Double.valueOf(newValue),0));
			break;
		case "STOCK":
			productService.Update(ID, attribute, new Product(ID,null, 0, Integer.valueOf(newValue)));
			break;
		}
	}

	@Override
	public void Delete() {
		// TODO Auto-generated method stub
		System.out.println("Enter the ID of the Product you want to delete");
		int ID = Utils.getInt();
		
		productService.Delete(ID);
	}

}
