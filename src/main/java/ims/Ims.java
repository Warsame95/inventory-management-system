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
	static final String DB_URL2 = "jdbc:mysql://35.246.105.113/inventory";

	static final String USER = "root";
	static final String PASS = "Manchester95";
	static final String PASS2 = "root";

	Utils utils = new Utils();

	public void Start() {

		dbConnect db = new dbConnect(JDBC_DRIVER, DB_URL2, USER, PASS2);

		System.out.println("What entity would you like to use?");
		System.out.println("Customers \nOrders \nProducts");
		String table = utils.getInput().toUpperCase();

		System.out.println("What would you like to do with " + table + ":");
		System.out.println("Create \nRead \nUpdate \nDelete");
		String action = utils.getInput().toUpperCase();
		boolean bool = true;
		while (bool) {
			switch (table) {
			case "CUSTOMERS":
				CustomerController cc = new CustomerController(new CustomerService(new CustomerDao(db)), utils);
				executeAction(cc, action);
				System.out.println("What entity would you like to use?");
				System.out.println("Customers \nOrders \nProducts");
				System.out.println("Enter STOP now, if you are finished");
				table = utils.getInput().toUpperCase();

				System.out.println("What would you like to do with " + table + ":");
				System.out.println("Create \nRead \nUpdate \nDelete");
				action = utils.getInput().toUpperCase();

				break;
			case "ORDERS":
				OrderController oc = new OrderController(new OrderService(new OrderDao(db)), utils);
				executeAction(oc, action);
				System.out.println("What entity would you like to use?");
				System.out.println("Customers \nOrders \nProducts");
				System.out.println("Enter STOP now, if you are finished");
				table = utils.getInput().toUpperCase();

				System.out.println("What would you like to do with " + table + ":");
				System.out.println("Create \nRead \nUpdate \nDelete");
				action = utils.getInput().toUpperCase();
				break;
			case "PRODUCTS":
				ProductController pc = new ProductController(new ProductService(new ProductDao(db)), utils);
				executeAction(pc, action);
				System.out.println("What entity would you like to use?");
				System.out.println("Customers \nOrders \nProducts");
				System.out.println("Enter STOP now, if you are finished");
				table = utils.getInput().toUpperCase();

				System.out.println("What would you like to do with " + table + ":");
				System.out.println("Create \nRead \nUpdate \nDelete");
				action = utils.getInput().toUpperCase();
				break;
			case "STOP":
				bool = false;
				break;
			default:
				System.out.println("That is an invalid input, please try again.");
				table = utils.getInput().toUpperCase();
			}

		}

	}

	public void executeAction(CrudController<?> crudController, String action) {

		boolean flag = true;
		while (flag) {
			switch (action) {
			case "CREATE":
				crudController.Create();
				flag = false;
				break;
			case "READ":
				crudController.Read();
				flag = false;
				break;
			case "UPDATE":
				crudController.Update();
				flag = false;
				break;
			case "DELETE":
				crudController.Delete();
				flag = false;
				break;
			default:
				System.out.println("That is an invalid input, please try again.");
				action = utils.getInput().toUpperCase();
			}
		}
	}

}
