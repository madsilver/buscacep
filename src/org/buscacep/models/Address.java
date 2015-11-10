package org.buscacep.models;

import java.io.Serializable;

public class Address implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private String street;
	private String neighborhood;
	private String city;
	private String state;
	private String zipcode;
	
	public Address(){}
			
	public Address(String street, String neighborhood, String city, String state, String zipcode){
		this.street = street;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	
	
}
