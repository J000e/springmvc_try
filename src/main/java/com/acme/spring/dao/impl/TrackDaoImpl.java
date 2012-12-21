package com.acme.spring.dao.impl;

import org.springframework.stereotype.Component;

import com.acme.spring.dao.TrackDao;
import com.acme.spring.model.Track;

@Component("trackDao")
public class TrackDaoImpl extends GenericDaoImpl<Track> implements TrackDao {

}
