package com.cspinformatique.openerp.entity;

public class Partner {
	public static final String OPENERP_KEY = "res.partner";
	
	private boolean customer;
	private String email;
	private String name;
	private String street;
	private String street2;
	private String zip;
	private String phone;
	
	public Partner(boolean customer, String email, String name, String street, String street2, String zip, String phone){
		this.customer = customer;
		this.email = email;
		this.name = name;
		this.street = street;
		this.street2 = street2;
		this.zip = zip;
		this.phone = phone;
	}

	public boolean isCustomer() {
		return customer;
	}

	public void setCustomer(boolean customer) {
		this.customer = customer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
