package com.metodologia.foro.utils;

import java.util.Date;
import com.metodologia.foro.entities.Usuario;

public class AuthenticationData {
    private Usuario usuario;
    private Date lastAction;

    public Date getLastAction() {
        return lastAction;
    }

    public void setLastAction(Date lastAction) {
        this.lastAction = lastAction;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
