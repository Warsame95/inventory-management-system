package Services;

import java.util.ArrayList;

import dao.Dao;
import domains.Customer;

public class CustomerService implements CrudService<Customer> {
	
	private Dao<Customer> customerDao;
	
	public CustomerService(Dao<Customer> customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public Customer Create(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.Create(customer);
	}

	@Override
	public ArrayList<Customer> Read() {
		// TODO Auto-generated method stub
		return customerDao.Read();
	}

	@Override
	public Customer Update(int ID, String attribute, Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.Update(ID, attribute, customer);
	}

	@Override
	public void Delete(int ID) {
		// TODO Auto-generated method stub
		customerDao.Delete(ID);
	}

}
