package Services;

import java.util.ArrayList;

import dao.Dao;
import domains.Order;

public class OrderService implements CrudService<Order> {
	
	Dao<Order> orderDao; 
	
	public OrderService(Dao<Order> orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public void Create(Order order) {
		// TODO Auto-generated method stub
		orderDao.Create(order);
	}

	@Override
	public ArrayList<Order> Read() {
		// TODO Auto-generated method stub
		return orderDao.Read();
	}

	@Override
	public void Update(int ID, String attribute, Order order) {
		// TODO Auto-generated method stub
		orderDao.Update(ID, attribute, order);
	}

	@Override
	public void Delete(int ID) {
		// TODO Auto-generated method stub
		orderDao.Delete(ID);
	}
	
}
