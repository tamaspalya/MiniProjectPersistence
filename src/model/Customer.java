package model;

public class Customer {
	//hi I'm DoM
	//and a customer is a customer :)
	
	private String name;
	private String address;
	private String zipcode;
	private String city;
	private String phoneNu;
	
	public Customer(String name, String address, String zipcode, String city, String phoneNu) {
		this.name = name;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.phoneNu = phoneNu;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNu() {
		return phoneNu;
	}

	public void setPhoneNu(String phoneNu) {
		this.phoneNu = phoneNu;
	}
}
