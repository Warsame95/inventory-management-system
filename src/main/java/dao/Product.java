package dao;

public class Product {
	private int id;
	private String Name;
	private double Price;
	private int Stock;
	
	public Product(int id, String Name, double Price, int Stock) {
		this.id = id;
		this.Name = Name;
		this.Price = Price;
		this.Stock = Stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	

}
