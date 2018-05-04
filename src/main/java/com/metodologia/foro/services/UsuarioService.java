package com.metodologia.foro.services;

import com.metodologia.foro.entities.Usuario;
import com.metodologia.foro.persistence.UsuarioDao;
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
        return usuarioDao.get(nombreUsuario, password);
    }
}
