package com.acme.tutorial.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Component;

public class SimpleJdbcDaoImpl extends SimpleJdbcDaoSupport {
	
	public int getCircleCount() {
		String sql = "select count(*) from circle";
		return this.getJdbcTemplate().queryForInt(sql);
	}
}
