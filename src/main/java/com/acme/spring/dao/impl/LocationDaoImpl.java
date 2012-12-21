package com.acme.spring.dao.impl;

import org.springframework.stereotype.Component;

import com.acme.spring.dao.LocationDao;
import com.acme.spring.model.Location;

@Component("locationDao")
public class LocationDaoImpl extends GenericDaoImpl<Location> implements LocationDao {


}
