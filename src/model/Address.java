package model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String line;

	private String city;

	private String state;

	public Address() {
	}

	public Address(String line, String city, String state) {
		super();
		this.line = line;
		this.city = city;
		this.state = state;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
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

}
