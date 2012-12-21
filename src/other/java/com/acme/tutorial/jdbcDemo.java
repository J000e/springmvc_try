package com.acme.tutorial;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.tutorial.dao.JdbcDaoImpl;
import com.acme.tutorial.dao.SimpleJdbcDaoImpl;
import com.acme.tutorial.model.Circle;

public class jdbcDemo {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		int circleId = 2;
		JdbcDaoImpl dao = context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		SimpleJdbcDaoImpl simpleDao = context.getBean("simpleJdbcDaoImpl", SimpleJdbcDaoImpl.class);
		System.out.println("count: " + simpleDao.getCircleCount()); 

		
		Circle circle = dao.getCircle(circleId);
		List<Circle> circles = dao.getAllCircle();
		
		System.out.println(circle);
		
		
		System.out.println("*************************");
		for (Circle element : circles) {
			System.out.println("\t - " + element);
		}
		System.out.println("*************************");
		
//		dao.insertCircle(new Circle(5, "ötödik circle"));
//		System.out.println(dao.getCircleName(2));
	}
}
