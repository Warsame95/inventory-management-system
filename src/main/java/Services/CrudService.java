package Services;

public interface CrudService<T> {
	
	public void Create(T t);
	
	public void Read();
	
	public void Update(int ID, String attribute,T t);
	
	public void Delete(int ID);
}
