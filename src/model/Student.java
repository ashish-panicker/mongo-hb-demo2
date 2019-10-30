package model;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(generator = "uid")
	@GenericGenerator(name = "uid", strategy = "uuid2")
	private String id;

	private String name;

	private String email;

	@ElementCollection
	@OrderColumn
	private Set<Address> addresses;

	public Student() {
	}

	public Student(String name, String email, Set<Address> address) {
		super();
		this.name = name;
		this.email = email;
		this.addresses = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	
	public Set<Address> getAddresses() {
		return addresses;
	}

}
