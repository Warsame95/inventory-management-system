package dao;

public class Customer {
	
	private int ID;
	private String Name;
	private String Email;
	private String Address;
	
	public Customer(int ID, String Name, String Email, String Address) {
		this.ID = ID;
		this.Name = Name;
		this.Email = Email;
		this.Address = Address;
	}
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	
	

}
