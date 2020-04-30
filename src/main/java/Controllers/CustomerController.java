package Controllers;

import java.util.ArrayList;

import Services.CrudService;
import dao.CustomerDao;
import database.dbConnect;
import domains.Customer;
import utils.Utils;

public class CustomerController implements CrudController<Customer>{
	
	private CrudService<Customer> customerService;
	
	public CustomerController(CrudService<Customer> customerService) {
		this.customerService = customerService;
	}
	

	@Override
	public Customer Create() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the Name of the Customer");
		String name = Utils.getInput();
		
		System.out.println("Enter the email of the Customer");
		String email = Utils.getInput();
		
		System.out.println("Enter the Address of the Customer");
		String address = Utils.getInput();
		
		System.out.println("Customer created");
		return customerService.Create(new Customer(name,email,address));

	}

	@Override
	public ArrayList<Customer> Read() {
		// TODO Auto-generated method stub
		ArrayList<Customer> customers = customerService.Read();
		for (Customer customer: customers) {
			System.out.println(customer.toString());
		}
		return customers;
	}

	@Override
	public Customer Update() {
		// TODO Auto-generated method stub
		System.out.println("Enter ID of Customer you want to update");
		int ID = Utils.getInt();
		
		System.out.println("Enter attribute you want to update i.e Name, Email or Address");
		String attribute = Utils.getInput().toUpperCase();
		
		System.out.println("Enter new Value");
		String newValue = Utils.getInput();
		
		switch(attribute) {
		case "NAME": 
			return customerService.Update(ID, attribute, new Customer(ID,newValue,null, null));
		case "EMAIL":
			return customerService.Update(ID, attribute, new Customer(ID,null,newValue, null));
		case "ADDRESS":
			return customerService.Update(ID, attribute, new Customer(ID,null,null, newValue));
		}
		return null;
		

	}

	@Override
	public void Delete() {
		// TODO Auto-generated method stub
		System.out.println("Enter ID of Customer you would like to delete");
		int ID = Utils.getInt();
		customerService.Delete(ID);
	}
	
	

}
