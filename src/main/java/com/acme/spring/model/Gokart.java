package com.acme.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Entity;

@Entity
@SequenceGenerator(sequenceName="GOKART_SEQ", name="GOKART_SEQ_GEN")
public class Gokart {
	
	@Id
	@GeneratedValue(generator="GOKART_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private long id;
	
	private int number;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Track track;
	private int ccm;
	
	
	public Gokart() {};
	
	public Gokart(int number, Track track, int ccm) {
		super();
		this.number = number;
		this.track = track;
		this.ccm = ccm;
	}

	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public Track getTrack() {
		return track;
	}
	
	public void setTrack(Track track) {
		this.track = track;
	}
	
	public int getCcm() {
		return ccm;
	}
	
	public void setCcm(int ccm) {
		this.ccm = ccm;
	}
	
}
