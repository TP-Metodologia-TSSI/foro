package com.metodologia.foro.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "respuestas")
public class Respuesta {
    private int id;
	private String contenido;
	private Date fecha;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    @Column(name = "descripcion", nullable = false, length = 30)
    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Column(name = "fecha", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    @ManyToOne
    @JoinColumn(name = "id_tema")
    private Tema tema;
    
    public Tema getTema() {
    	return tema;
    }

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    public Usuario getUsuario() {
    	return usuario;
    }
}
