package model;

public class Supplier {
	
	private int id;
	private String name;
	private String address;
	private String country;
	private String phoneNo;
	
	public Supplier(int id, String name, String address, String country, String phoneNo) {
		this.name = name;
		this.address = address;
		this.country = country;
		this.phoneNo = phoneNo;
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}
