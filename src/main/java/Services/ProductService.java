package Services;

import java.util.ArrayList;

import dao.Dao;
import domains.Product;

public class ProductService implements CrudService<Product> {
	
	Dao<Product> productDao;
	
	public ProductService(Dao<Product> productDao) {
		this.productDao = productDao;
	}

	@Override
	public void Create(Product product) {
		// TODO Auto-generated method stub
		productDao.Create(product);
	}

	@Override
	public ArrayList<Product> Read() {
		// TODO Auto-generated method stub
		return productDao.Read();
	}

	@Override
	public void Update(int ID, String attribute, Product product) {
		// TODO Auto-generated method stub
		productDao.Update(ID, attribute, product);
	}

	@Override
	public void Delete(int ID) {
		// TODO Auto-generated method stub
		productDao.Delete(ID);
	}

}
