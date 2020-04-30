package Services;

import java.util.ArrayList;

public interface CrudService<T> {
	
	public T Create(T t);
	
	public ArrayList<T> Read();
	
	public T Update(int ID, String attribute,T t);
	
	public void Delete(int ID);
}
