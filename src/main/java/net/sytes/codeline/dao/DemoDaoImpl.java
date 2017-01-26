package net.sytes.codeline.dao;

import java.util.List;
import java.util.Random;

import org.hibernate.criterion.Order;
import org.apache.commons.lang.time.DateUtils;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sytes.codeline.entities.Demo;

/**
 * @author Dusan Nesic
 * Implementation of the DAO layer implementing all its methods
 */
@Repository
public class DemoDaoImpl implements DemoDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public DemoDaoImpl() {}

	public DemoDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Demo addDemo(Demo demo) {
		Demo current = (Demo) sessionFactory.getCurrentSession().createCriteria(Demo.class)
				.add(Restrictions.eq("primarniKljuc", demo.getPrimarniKljuc()))
				.uniqueResult();
		if (current == null) {
			sessionFactory.getCurrentSession().save(demo);
			current = demo;
			
			return current;
		}

		return null;
	}

}
