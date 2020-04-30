package Services;

import java.util.ArrayList;

public interface CrudService<T> {
	
	public void Create(T t);
	
	public ArrayList<T> Read();
	
	public void Update(int ID, String attribute,T t);
	
	public void Delete(int ID);
}
