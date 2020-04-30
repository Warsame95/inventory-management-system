package ims;

import Controllers.CrudController;
import Controllers.CustomerController;
import Controllers.OrderController;
import Controllers.ProductController;
import Services.CustomerService;
import Services.OrderService;
import Services.ProductService;
import dao.CustomerDao;
import dao.OrderDao;
import dao.ProductDao;
import database.dbConnect;
import utils.Utils;

public class Ims {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/gamedb?useSSL=false";
	static final String USER = "root";
	static final String PASS = "Manchester95";

	public void Start() {

		dbConnect db = new dbConnect(JDBC_DRIVER, DB_URL, USER, PASS);

		System.out.println("What entity would you like to use?");
		System.out.println("Customers \nOrders \nProducts");
		String table = Utils.getInput().toUpperCase();

		System.out.println("What would you like to do with " + table + ":");
		System.out.println("Create \nRead \nUpdate \nDelete");
		String action = Utils.getInput().toUpperCase();
		boolean bool = true;
		while (bool) {
			switch (table) {
			case "CUSTOMERS":
				CustomerController cc = new CustomerController(new CustomerService(new CustomerDao(db)));
				executeAction(cc, action);
				System.out.println("What entity would you like to use?");
				System.out.println("Customers \nOrders \nProducts");
				System.out.println("Enter STOP now, if you are finished");
				table = Utils.getInput().toUpperCase();
				break;
			case "ORDERS":
				OrderController oc = new OrderController(new OrderService(new OrderDao(db)));
				executeAction(oc, action);
				System.out.println("What entity would you like to use?");
				System.out.println("Customers \nOrders \nProducts");
				System.out.println("Enter STOP now, if you are finished");
				table = Utils.getInput().toUpperCase();
				break;
			case "PRODUCTS":
				ProductController pc = new ProductController(new ProductService(new ProductDao(db)));
				executeAction(pc, action);
				System.out.println("What entity would you like to use?");
				System.out.println("Customers \nOrders \nProducts");
				System.out.println("Enter STOP now, if you are finished");
				table = Utils.getInput().toUpperCase();
				break;
			case "STOP":
				bool = false;
				break;
			default:
				System.out.println("That is an invalid input, please try again.");
				table = Utils.getInput().toUpperCase();
			}

		}

	}

	public void executeAction(CrudController crudController, String action) {
		switch (action) {
		case "CREATE":
			crudController.Create();
			break;
		case "READ":
			crudController.Read();
			break;
		case "UPDATE":
			crudController.Update();
			break;
		case "DELETE":
			crudController.Delete();
			break;
		}
	}

}
