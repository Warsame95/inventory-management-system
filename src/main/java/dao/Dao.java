package dao;

public interface Dao<T> {
	
	public void Create(T t);
	
	public void Read();
	
	public void Update(int id, String attribute, T t);
	
	public void Delete(int id);
}
