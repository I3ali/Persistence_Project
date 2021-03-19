package model;

public class Supplier {
	private String name;
	private String address;
	private String country;
	private String phoneno;
	private String email;
	private int id;
    private int zipCode;
	
	public Supplier(int id, String name, String address, String country, String phoneno, String email, int zipCode) {
		this.setId(id);
		this.setName(name);
		this.setAddress(address);
		this.setCountry(country);
		this.setPhoneno(phoneno);
		this.setEmail(email);
	}
	
	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id){
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

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
