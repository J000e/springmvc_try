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
@SequenceGenerator(sequenceName="PILOT_SEQ", name="PILOT_SEQ_GEN")
public class Pilot {

	@Id
	@GeneratedValue(generator="PILOT_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private long id;
	private String name;
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="lapTime")
	private List<LapTime> times;
	
	
	public Pilot() {}
	
	public Pilot(String name) {
		super();
		this.name = name;
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
	
}
