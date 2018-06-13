package com.metodologia.foro.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@NoArgsConstructor
@Table(name = "respuesta")
public class Respuesta {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "contenido", nullable = false)
    private String contenido;

    @Column(name = "fecha", nullable = false)
    private Date fechaCreacion;

    @Column(name = "id_usuario", unique = true, nullable = false)
    private long id_creador;

    @Column(name = "id_tema", unique = true, nullable = false)
    private long id_tema;
    
    public Respuesta() {
    	
    }

    public Respuesta(long id, String contenido, Date fechaCreacion, long id_creador, long id_tema) {
        this.id = id;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.id_creador = id_creador;
        this.id_tema = id_tema;
    }

    public Respuesta(String contenido, long id_creador, long id_tema) {
        this.contenido = contenido;
        this.fechaCreacion = new Date();
        this.id_creador = id_creador;
        this.id_tema = id_tema;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFechaCreacion() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(this.fechaCreacion);
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public long getId_creador() {
        return id_creador;
    }

    public void setId_creador(long id_creador) {
        this.id_creador = id_creador;
    }

    public long getId_tema() {
        return id_tema;
    }

    public void setId_tema(long id_tema) {
        this.id_tema = id_tema;
    }
}
