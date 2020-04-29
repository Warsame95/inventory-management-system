package Controllers;

import Services.CrudService;
import dao.CustomerDao;
import database.dbConnect;
import domains.Customer;
import utils.Utils;

public class CustomerController implements CrudController{
	
	private CrudService<Customer> customerService;
	
	public CustomerController(CrudService<Customer> customerService) {
		this.customerService = customerService;
	}
	

	@Override
	public void Create() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the Name of the Customer");
		String name = Utils.getInput();
		
		System.out.println("Enter the email of the Customer");
		String email = Utils.getInput();
		
		System.out.println("Enter the Address of the Customer");
		String address = Utils.getInput();
		
		customerService.Create(new Customer(name,email,address));
		System.out.println("Customer created");
	}

	@Override
	public void Read() {
		// TODO Auto-generated method stub
		customerService.Read();
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		System.out.println("Enter ID of Customer you want to update");
		int ID = Utils.getInt();
		
		System.out.println("Enter attribute you want to update i.e Name, Email or Address");
		String attribute = Utils.getInput().toUpperCase();
		
		System.out.println("Enter new Value");
		String newValue = Utils.getInput();
		
		switch(attribute) {
		case "NAME": 
			customerService.Update(ID, attribute, new Customer(ID,newValue,null, null));
			break;
		case "EMAIL":
			customerService.Update(ID, attribute, new Customer(ID,null,newValue, null));
		    break;
		case "ADDRESS":
			customerService.Update(ID, attribute, new Customer(ID,null,null, newValue));
			break;
		}
		

	}

	@Override
	public void Delete() {
		// TODO Auto-generated method stub
		System.out.println("Enter ID of Customer you would like to delete");
		int ID = Utils.getInt();
		customerService.Delete(ID);
	}
	
	

}
