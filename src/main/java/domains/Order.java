package domains;

public class Order {
	
	private int OrderId;
	private int CustomerId;
	private int ProductId;
	private int Quantity;
	private double Price;
	
	
	public Order (int OrderId, int ProductId, int CustomerId, int Quantity, double Price) {
		this.OrderId = OrderId;
		this.CustomerId = CustomerId;
		this.ProductId = ProductId;
		this.Quantity = Quantity;
		this.Price = Price;
	}
	
	public Order(int OrderId, int ProductId, int CustomerId, int Quantity) {
		this.OrderId = OrderId;
		this.CustomerId = CustomerId;
		this.ProductId = ProductId;
		this.Quantity = Quantity;
	}
	
	public Order(int ProductId, int CustomerId, int Quantity) {
		this.ProductId = ProductId;
		this.CustomerId = CustomerId;
		this.Quantity = Quantity;
	}


	public int getOrderId() {
		return OrderId;
	}


	public void setOrderId(int orderId) {
		OrderId = orderId;
	}


	public int getCustomerId() {
		return CustomerId;
	}


	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}


	public int getProductId() {
		return ProductId;
	}


	public void setProductId(int productId) {
		ProductId = productId;
	}


	public int getQuantity() {
		return Quantity;
	}


	public void setQuantity(int quantity) {
		Quantity = quantity;
	}


	public double getPrice() {
		return Price;
	}


	public void setPrice(double price) {
		Price = price;
	}

	@Override
	public String toString() {
		return "[OrderId= " + OrderId + ", CustomerId= " + CustomerId + ", ProductId= " + ProductId + ", Quantity= "
				+ Quantity + ", Price= " + Price + "]";
	}
	
	

}
