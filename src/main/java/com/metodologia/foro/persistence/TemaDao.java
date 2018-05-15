package com.metodologia.foro.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.metodologia.foro.entities.Subforo;
import com.metodologia.foro.entities.Tema;

public class TemaDao extends AbstractDao<Tema> {

	public TemaDao(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Tema> getAll() {
		Session session = this.sessionFactory.openSession();
		List<Tema> list = session.createQuery("FROM temas").list();
		session.close();

		return list;
	}

	@Override
	public Tema getById(int id) {
		Session session = this.sessionFactory.openSession();
		Tema tema = (Tema) session.createQuery("FROM temas where id = :i").setParameter("i", id).list()
				.get(0);
		session.close();

		return tema;
	}

	@Override
	public void save(Tema value) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();

		session.save(value);

		session.close();
	}

}
