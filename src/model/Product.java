package model;

import java.math.BigDecimal;

public class Product {
	
	private int id;
	private String name;
	private BigDecimal purchasePrice;
	private BigDecimal salesPrice;
	private BigDecimal rentPrice;
	private String countryOfOrigin;
	private int minStock;
	private int stock;
	private int supplierId;
	
	public Product(int id, String name, BigDecimal purchasePrice, BigDecimal salesPrice, BigDecimal rentPrice,
			String countryOfOrigin, int minStock, int stock, int supplierId) {
		this.id = id;
		this.name = name;
		this.purchasePrice = purchasePrice;
		this.salesPrice = salesPrice;
		this.rentPrice = rentPrice;
		this.countryOfOrigin = countryOfOrigin;
		this.minStock = minStock;
		this.stock = stock;
		this.supplierId = supplierId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public BigDecimal getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(BigDecimal salesPrice) {
		this.salesPrice = salesPrice;
	}

	public BigDecimal getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(BigDecimal rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public int getMinStock() {
		return minStock;
	}

	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	
	//overriding the equals and hashcode methods for testing
	@Override
	public boolean equals(Object obj) {
		//if the reference is the same, they are the same object
		if(this == obj)
			return true;
		
		//if the object is null or they are not the same class, they cannot be equal
		if(obj == null || obj.getClass() != this.getClass())
			return false;
		
		//casting from object as we already know from the last 'if' that it is the same class
		Product pr = (Product) obj;
		//we only need to check the id as different products have different ids
		return this.id == pr.getId();
	}
	
	//our hashCode() method will use the id as a hashcode as it is unique, but same for the same product
	@Override
	public int hashCode() {
		return this.id;
	}
}
