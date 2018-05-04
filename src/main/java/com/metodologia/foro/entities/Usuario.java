package com.metodologia.foro.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    private int id;
	private String nombre;
	private String urlImagen;
	private String password;
	private Date fechaSubscripcion;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    @Column(name = "nombre", nullable = false, length = 30)
    public String getNombreUsuario() {
        return nombre;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombre = nombreUsuario;
    }

    @Column(name = "url_imagen", nullable = false, length = 30)
    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    @Column(name = "subscripcion", nullable = false)
    public Date getFechaSubscripcion() {
        return fechaSubscripcion;
    }

    @Column(name = "password", nullable = false, length = 20)
    public String getPassword() {
        return password;
    }
}
