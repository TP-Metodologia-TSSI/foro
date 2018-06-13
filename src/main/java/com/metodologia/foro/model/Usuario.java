package com.metodologia.foro.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "nombre", unique = true, nullable = false)
    private String name;

    @Column(name = "pass", nullable = false, length = 20)
    private String password;

    @Column(name = "url_imagen")
    private String urlImage;

    @Column(name = "fecha_suscripcion", nullable = false)
    private Date fechaSubscripcion;

    @Column(name = "tipo_usuario", nullable = false)
    private int tipoUsuario;

    public Usuario(long id, String name, String password, String urlImage, Date fechaSubscripcion, int tipoUsuario) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.urlImage = urlImage;
        this.fechaSubscripcion = fechaSubscripcion;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(String name, String password, String urlImage) {
        this.name = name;
        this.password = password;
        this.urlImage = urlImage;
        this.fechaSubscripcion = new Date();
        this.tipoUsuario = 2;
    }
    
    public Usuario() {
    	
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Date getFechaSubscripcion() {
        return fechaSubscripcion;
    }

    public void setFechaSubscripcion(Date fechaSubscripcion) {
        this.fechaSubscripcion = fechaSubscripcion;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
