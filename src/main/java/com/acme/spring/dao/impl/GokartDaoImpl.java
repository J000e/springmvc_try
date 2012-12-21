package com.acme.spring.dao.impl;

import org.springframework.stereotype.Component;

import com.acme.spring.dao.GokartDao;
import com.acme.spring.model.Gokart;

@Component("gokartDao")
public class GokartDaoImpl extends GenericDaoImpl<Gokart> implements GokartDao {


}
