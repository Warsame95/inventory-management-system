package Controllers;

import java.util.ArrayList;

import Services.CrudService;
import domains.Order;
import utils.Utils;

public class OrderController implements CrudController<Order> {
	
	private CrudService<Order> orderService;
	
	Utils utils;
	
	public OrderController(CrudService<Order> orderService,  Utils passedUtil) {
		this.orderService = orderService;
		this.utils = passedUtil;
	}

	@Override
	public Order Create() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter Customer ID");
		int customerID = utils.getInt();
		
		System.out.println("Enter Product ID");
		int productID = utils.getInt();
		
		System.out.println("Enter the Quantity ordered");
		int quantity = utils.getInt();
		
		System.out.println("Order created");
		Order ordTemp = new Order(productID, customerID, quantity);
		orderService.Create(ordTemp);
		return ordTemp;
	} 

	@Override
	public ArrayList<Order> Read() {
		// TODO Auto-generated method stub
		ArrayList<Order> orders = orderService.Read();
		for (Order order: orders) {
			System.out.println(order.toString());
		}
		return orders;
	}

	@Override
	public Order Update() {
		// TODO Auto-generated method stub
		Order ordTemp;
		System.out.println("Enter ID or order you want to update");
		int ID = utils.getInt();
		
		System.out.println("Enter the attribute you want to update i.e customerid, productid or quantity");
		String attribute = utils.getInput().toUpperCase();
		
		System.out.println("Enter the new value");
		int newValue = utils.getInt();
		
		switch(attribute) {
		case "CUSTOMERID":
			ordTemp = new Order(ID, newValue, 0,0);
			orderService.Update(ID, attribute, ordTemp);
			return ordTemp;
		case "PRODUCTID":
			ordTemp = new Order(ID,0, newValue,0);
			orderService.Update(ID, attribute, new Order(ID,0, newValue,0));
			return ordTemp;
		case "QUANTITY":
			ordTemp = new Order(ID,0, 0, newValue);
			orderService.Update(ID, attribute, new Order(ID,0, 0, newValue));
			return ordTemp;
		}
		return null;
		
	}

	@Override
	public void Delete() {
		// TODO Auto-generated method stub
		System.out.println("Enter ID of order you would like to delete");
		int ID = utils.getInt();
		orderService.Delete(ID);
		
	}

}
