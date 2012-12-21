package com.acme.spring.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.acme.spring.dao.GenericDao;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {
	
	@Autowired
	protected SessionFactory sessionFactory;
	private Class<T> type;
	
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	@Override
	public long countAll(final Map<String, Object> params) {
		final StringBuffer hql = new StringBuffer();
		hql.append("SELECT count(*) from ")
				.append(type.getSimpleName());
		
		final Query query = getSessionFactory().getCurrentSession().createQuery(hql.toString());
		return (Long) query.uniqueResult();
	}

	@Override
	public T create(T t) {
		sessionFactory.getCurrentSession().save(t);
		return t;
	}

	@Override
	public void delete(Object id) {
		T toDelete = find(id);
		sessionFactory.getCurrentSession().delete(toDelete);
	}

	@Override
	public T find(final Object id) {
		return (T) sessionFactory.getCurrentSession().load(type, (Serializable) id);
	}

	@Override
	public T update(T t) {
		return (T) sessionFactory.getCurrentSession().merge(t);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
