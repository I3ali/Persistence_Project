package model;

public class Customer {
	private int id;
	private String fname;
    private String lname;
    private String email;
    private String address;
    private String phoneNumber;
    private int zipCode;
    
    public Customer (int id, String fname, String lname, String email, String address, String phoneNumber, int zipCode) {
		this.setId(id);
		this.setFname(fname);
    	this.setLname(lname);
        this.setEmail(email);
        this.setAddress(address);
        this.setPhoneNumber(phoneNumber);
        this.setzipCode(zipCode);
    }
    
	public String getFname() {
		return fname;
	}

    public String getLname() {
		return lname;
	}
    
	public String getEmail() {
		return email;
	}

    public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public int getZipCode() {
		return zipCode;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

    public void setLname(String lname) {
		this.lname = lname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setzipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}