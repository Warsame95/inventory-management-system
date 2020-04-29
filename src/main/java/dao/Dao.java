package dao;

import java.util.ArrayList;

public interface Dao<T> {
	
	public T Create(T t);
	
	public ArrayList<T> Read();
	
	public T Update(int id, String attribute, T t);
	
	public void Delete(int id);
}
