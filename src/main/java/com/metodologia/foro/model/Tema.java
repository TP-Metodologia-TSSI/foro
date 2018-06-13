package com.metodologia.foro.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@NoArgsConstructor
@Table(name = "tema")
public class Tema {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private long id_tema;

    @Column(name = "titulo", unique = true, nullable = false)
    private String titulo;

    @Column(name = "descripcion", nullable = false)
    private String contenido;

    @Column(name = "fecha", nullable = false)
    private Date fechaCreacion;

    @Column(name = "id_usuario", nullable = false)
    private long id_creador;

    @Column(name = "id_subforo", nullable = false)
    private long id_subforo;
    
    public Tema() {
    	
    }

    public Tema(long id_tema, String titulo, String contenido, long id_creador, Date fechaCreacion, long id_subforo) {
        this.id_tema = id_tema;
        this.titulo = titulo;
        this.contenido = contenido;
        this.id_creador = id_creador;
        this.fechaCreacion = fechaCreacion;
        this.id_subforo = id_subforo;
    }

    public Tema(String titulo, String contenido, long id_creador, long id_subforo) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.id_creador = id_creador;
        this.fechaCreacion = new Date();
        this.id_subforo = id_subforo;
    }

    public long getId_tema() {
        return id_tema;
    }

    public void setId_tema(long id_tema) {
        this.id_tema = id_tema;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public long getCreador() {
        return id_creador;
    }

    public void setCreador(long id_creador) {
        this.id_creador = id_creador;
    }

    public String getFechaCreacion() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(this.fechaCreacion);
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public long getSubforo() {
        return id_subforo;
    }

    public void setSubforo(long id_subforo) {
        this.id_subforo = id_subforo;
    }
}
