package com.metodologia.foro.services;

import com.metodologia.foro.entities.Usuario;
import com.metodologia.foro.persistence.UsuarioDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    UsuarioDao usuarioDao;

    @Autowired
    public UsuarioService(UsuarioDao dao) {
        this.usuarioDao = dao;
    }

    public Usuario login(String nombreUsuario, String password) {
    	List<Usuario> usuarios = usuarioDao.getAll();
    	
    	for (Usuario u : usuarios) {
    		if (u.getNombreUsuario() == nombreUsuario && u.getPassword() == password) {
    			return u;
    		}
    	}
    	
        return null;
    }
}
