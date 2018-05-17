package com.metodologia.foro.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metodologia.foro.entities.Usuario;

import java.util.List;

@Repository
public class UsuarioDao extends AbstractDao<Usuario> {
	@Autowired
	public UsuarioDao(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public List<Usuario> getAll() {
		Session session = this.sessionFactory.openSession();
		List<Usuario> list = session.createQuery("FROM usuarios").list();
		session.close();

		return list;
	}

	@Override
	Usuario getById(int id) {
		Session session = this.sessionFactory.openSession();
		Usuario usuario = (Usuario) session.createQuery("FROM usuarios where id = :i").setParameter("i", id).list()
				.get(0);
		session.close();

		return usuario;
	}

	@Override
	void save(Usuario value) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();

		session.save(value);

		session.close();
	}
}