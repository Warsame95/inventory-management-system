package Controllers;

import java.util.ArrayList;

import database.dbConnect;

public interface CrudController<T> {
	
	public T Create();
	
	public ArrayList<T> Read();
	
	public T Update();
	
	public void Delete();
	
}
