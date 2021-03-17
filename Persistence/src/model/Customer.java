package model;

public class Customer {
	private int id;
	private String fname;
    private String lname;
    private String email;
    private String address;
    private String phoneNumber;
    
    public Customer (int id, String fname, String lname, String email, String address, String phonenumber) {
        this.setId(id);
		this.setFname(fname);
    	this.setLname(lname);
        this.setEmail(email);
        this.setAddress(address);
        this.setPhoneNumber(phoneNumber);
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

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
