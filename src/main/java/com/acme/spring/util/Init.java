package com.acme.spring.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.acme.spring.dao.GokartDao;
import com.acme.spring.dao.LapTimeDao;
import com.acme.spring.dao.LocationDao;
import com.acme.spring.dao.PilotDao;
import com.acme.spring.dao.TrackDao;
import com.acme.spring.model.Location;
import com.acme.spring.model.Pilot;
import com.acme.spring.model.Track;

public class Init {
	
	@Autowired
	private GokartDao gokartDao;
	@Autowired
	private LapTimeDao lapTimeDao;
	@Autowired
	private LocationDao locationDao;
	@Autowired
	private PilotDao pilotDao;
	@Autowired
	private TrackDao trackDao;

	public static void main(String[] args) {
		new Init();
	}
	
	private Init() {
		Location location_asd = new Location("Budapest", "Asd street");
		new Track("Track one", location_asd);
		Pilot pilot = new Pilot("Pilot 1");
		
		
//		gokartDao.create(getGokart())
	}

}
