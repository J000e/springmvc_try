package com.acme.spring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Entity;

@Entity
@SequenceGenerator(sequenceName="TRACK_SEQ", name="TRACK_SEQ_GEN")
public class Track {
	
	@Id
	@GeneratedValue(generator="TRACK_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private long id;
	private String name;
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="track")
	private List<LapTime> times;
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="track")
	private List<Gokart> karts;
	private Location location;
	
	
	public Track() {}
	
	public Track(String name, Location location) {
		super();
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<LapTime> getTimes() {
		return times;
	}
	
	public void setTimes(List<LapTime> times) {
		this.times = times;
	}
	
	public List<Gokart> getKarts() {
		return karts;
	}
	
	public void setKarts(List<Gokart> karts) {
		this.karts = karts;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
}
