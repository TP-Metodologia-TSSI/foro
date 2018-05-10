package com.metodologia.foro.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.metodologia.foro.entities.Respuesta;
import com.metodologia.foro.entities.Usuario;

public class RespuestaDao extends AbstractDao<Respuesta> {
	@Autowired
	public RespuestaDao(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public List<Respuesta> getAll() {
		Session session = this.sessionFactory.openSession();
		List<Respuesta> list = session.createQuery("FROM respuestas").list();
		session.close();

		return list;
	}

	@Override
	Respuesta getById(int id) {
		Session session = this.sessionFactory.openSession();
		Respuesta respuesta = (Respuesta) session.createQuery("FROM respuestas where id = :i").setParameter("i", id).list()
				.get(0);
		session.close();

		return respuesta;
	}

	@Override
	void save(Respuesta value) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();

		session.save(value);

		session.close();
	}
}
