package com.acme.spring.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Entity;

@Entity
@SequenceGenerator(sequenceName="LOCATION_SEQ", name="LOCATION_SEQ_GEN")
public class Location {
	
	@Id
	@GeneratedValue(generator="LOCATION_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private long id;
	private String city;
	private String street;
	
	public Location() {}
	
	public Location(String city, String street) {
		super();
		this.city = city;
		this.street = street;
	}


	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
}
