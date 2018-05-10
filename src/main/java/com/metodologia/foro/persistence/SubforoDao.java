package com.metodologia.foro.persistence;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.metodologia.foro.entities.Subforo;

public class SubforoDao extends AbstractDao<Subforo> {
	@Autowired
	public SubforoDao(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	List<Subforo> getAll() {
		Session session = this.sessionFactory.openSession();
		List<Subforo> list = session.createQuery("FROM subforos").list();
		session.close();

		return list;
	}

	@Override
	Subforo getById(int id) {
		Session session = this.sessionFactory.openSession();
		Subforo subforo = (Subforo) session.createQuery("FROM subforos where id = :i").setParameter("i", id).list()
				.get(0);
		session.close();

		return subforo;
	}

	@Override
	void save(Subforo value) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();

		session.save(value);

		session.close();
	}

}
