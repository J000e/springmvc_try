package com.acme.spring.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Entity
@Table(name="LAP_TIME")
@SequenceGenerator(sequenceName="LAP_TIME_SEQ", name="LAP_TIME_SEQ_GEN")
public class LapTime {

	@Id
	@GeneratedValue(generator="LAP_TIME_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private long id;
	
	private int laptime;
	private Date dateOfTheLap;
	private int runNumber;
	
	@ManyToOne
	@JoinColumn(name="gokart_id")
	private Gokart gokart;
	
	@ManyToOne
	@JoinColumn(name="pilot_id")
	private Pilot pilot;
	
	@ManyToOne
	@JoinColumn(name="track_id")
	private Track track;
	
	
	public LapTime() {}
	
	
	public LapTime(int laptime, Date dateOfTheLap, int runNumber,
			Gokart gokart, Pilot pilot, Track track) {
		super();
		this.laptime = laptime;
		this.dateOfTheLap = dateOfTheLap;
		this.runNumber = runNumber;
		this.gokart = gokart;
		this.pilot = pilot;
		this.track = track;
	}


	public int getLaptime() {
		return laptime;
	}
	
	public void setLaptime(int laptime) {
		this.laptime = laptime;
	}
	
	public Date getDateOfTheLap() {
		return dateOfTheLap;
	}
	
	public void setDateOfTheLap(Date dateOfTheLap) {
		this.dateOfTheLap = dateOfTheLap;
	}
	
	public int getRunNumber() {
		return runNumber;
	}
	
	public void setRunNumber(int runNumber) {
		this.runNumber = runNumber;
	}
	
	public Gokart getGokart() {
		return gokart;
	}
	
	public void setGokart(Gokart gokart) {
		this.gokart = gokart;
	}
	
	public Pilot getPilot() {
		return pilot;
	}
	
	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}
	
	public Track getTrack() {
		return track;
	}
	
	public void setTrack(Track track) {
		this.track = track;
	}
	
}
