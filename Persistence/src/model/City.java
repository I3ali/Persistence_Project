package model;

public class City {
	private int zipcode;
    private String name;
	
	public City(int zipcode, String name) {
		this.setZipcode(zipcode);
		this.setName(name);
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}