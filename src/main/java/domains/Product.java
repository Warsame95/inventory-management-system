package domains;

public class Product {
	private int ID;
	private String Name;
	private double Price;
	private int Stock;
	
	public Product(int ID, String Name, double Price, int Stock) {
		this.ID = ID;
		this.Name = Name;
		this.Price = Price;
		this.Stock = Stock;
	}
	
	public Product(String Name, double Price, int Stock) {
		this.Name = Name;
		this.Price = Price;
		this.Stock = Stock;
	}

	public int getID() {
		return ID;
	}

	public void setId(int ID) {
		this.ID = ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}

	@Override
	public String toString() {
		return "[productId= " + ID + ", Name= " + Name + ", Price= " + Price + ", Stock= " + Stock + "]";
	}
	
	

}
