package com.acme.spring.dao.impl;

import org.springframework.stereotype.Component;

import com.acme.spring.dao.PilotDao;
import com.acme.spring.model.Pilot;

@Component("pilotDao")
public class PilotDaoImpl extends GenericDaoImpl<Pilot> implements PilotDao {

}
