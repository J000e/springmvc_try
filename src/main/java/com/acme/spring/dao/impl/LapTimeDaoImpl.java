package com.acme.spring.dao.impl;

import org.springframework.stereotype.Component;

import com.acme.spring.dao.LapTimeDao;
import com.acme.spring.model.LapTime;

@Component("lapTimeDao")
public class LapTimeDaoImpl extends GenericDaoImpl<LapTime> implements LapTimeDao {

}
