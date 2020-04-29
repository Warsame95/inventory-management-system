package Services;

import dao.Dao;
import domains.Customer;

public class CustomerService implements CrudService<Customer> {
	
	private Dao<Customer> customerDao;
	
	public CustomerService(Dao<Customer> customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void Create(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.Create(customer);
	}

	@Override
	public void Read() {
		// TODO Auto-generated method stub
		customerDao.Read();
	}

	@Override
	public void Update(int ID, String attribute, Customer customer) {
		// TODO Auto-generated method stub
		customerDao.Update(ID, attribute, customer);
	}

	@Override
	public void Delete(int ID) {
		// TODO Auto-generated method stub
		customerDao.Delete(ID);
	}

}
