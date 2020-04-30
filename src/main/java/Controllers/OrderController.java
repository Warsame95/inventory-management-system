package Controllers;

import java.util.ArrayList;

import Services.CrudService;
import domains.Order;
import utils.Utils;

public class OrderController implements CrudController<Order> {
	
	private CrudService<Order> orderService;
	
	public OrderController(CrudService<Order> orderService) {
		this.orderService = orderService;
	}

	@Override
	public Order Create() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter Customer ID");
		int customerID = Utils.getInt();
		
		System.out.println("Enter Product ID");
		int productID = Utils.getInt();
		
		System.out.println("Enter the Quantity ordered");
		int quantity = Utils.getInt();
		
		System.out.println("Order created");
		return orderService.Create(new Order(productID, customerID ,quantity));
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
		System.out.println("Enter ID or order you want to update");
		int ID = Utils.getInt();
		
		System.out.println("Enter the attribute you want to update i.e customerid, productid or quantity");
		String attribute = Utils.getInput().toUpperCase();
		
		System.out.println("Enter the new value");
		int newValue = Utils.getInt();
		
		switch(attribute) {
		case "CUSTOMERID":
			return orderService.Update(ID, attribute, new Order(ID, newValue, 0,0));
		case "PRODUCTID":
			return orderService.Update(ID, attribute, new Order(ID,0, newValue,0));
		case "QUANTITY":
			return orderService.Update(ID, attribute, new Order(ID,0, 0, newValue));
		}
		return null;
		
	}

	@Override
	public void Delete() {
		// TODO Auto-generated method stub
		System.out.println("Enter ID of order you would like to delete");
		int ID = Utils.getInt();
		orderService.Delete(ID);
		
	}

}
