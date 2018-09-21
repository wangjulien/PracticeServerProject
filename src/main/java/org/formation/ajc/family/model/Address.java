package org.formation.ajc.family.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String road;
	private int postalCode;
	private String city;

	public Address() {
		super();
	}

	public Address(String road, int postalCode, String city) {
		super();
		this.road = road;
		this.postalCode = postalCode;
		this.city = city;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return road + ", " + postalCode + ", " + city;
	}	
}
