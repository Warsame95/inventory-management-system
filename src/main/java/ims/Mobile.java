package ims;

public class Mobile implements Product{
	
	private final int ID;
	private String Brand;
	private String Name;
	
	public Mobile(int ID, String Brand, String Name) {
		this.ID = ID;
		this.Brand = Brand;
		this.Name = Name;
	}

	public int getID() {
		// TODO Auto-generated method stub
		return this.ID;
	}

	public void setName(String Name) {
		this.Name = Name;
		
	}

	public String getName() {
		
		return this.Name;
	}

	public void setBrand(String Brand) {
		this.Brand = Brand;
		
	}

	public String getBrand() {
		// TODO Auto-generated method stub
		return this.Brand;
	}
	
	
	
	
	
	

}
