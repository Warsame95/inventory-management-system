package Controllers;

import Services.CrudService;
import domains.Order;
import utils.Utils;

public class OrderController implements CrudController {
	
	private CrudService<Order> orderService;
	
	public OrderController(CrudService<Order> orderService) {
		this.orderService = orderService;
	}

	@Override
	public void Create() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter Customer ID");
		int customerID = Utils.getInt();
		
		System.out.println("Enter Product ID");
		int productID = Utils.getInt();
		
		System.out.println("Enter the Quantity ordered");
		int quantity = Utils.getInt();
		
		orderService.Create(new Order(productID, customerID ,quantity));
	} 

	@Override
	public void Read() {
		// TODO Auto-generated method stub
		orderService.Read();
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		System.out.println("Enter ID or order you want to update");
		int ID = Utils.getInt();
		
		System.out.println("Enter the attribute you want to update i.e customerid, productid or quantity");
		String attribute = Utils.getInput().toUpperCase();
		
		System.out.println("Enter the new value");
		int newValue = Utils.getInt();
		
		switch(attribute) {
		case "CUSTOMERID":
			orderService.Update(ID, attribute, new Order(ID, newValue, 0,0));
			break;
		case "PRODUCTID":
			orderService.Update(ID, attribute, new Order(ID,0, newValue,0));
			break;
		case "QUANTITY":
			orderService.Update(ID, attribute, new Order(ID,0, 0, newValue));
			break;
		}
		
	}

	@Override
	public void Delete() {
		// TODO Auto-generated method stub
		System.out.println("Enter ID of order you would like to delete");
		int ID = Utils.getInt();
		orderService.Delete(ID);
		
	}

}
