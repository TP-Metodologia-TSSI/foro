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

    @JoinColumn(name = "id_usuario", unique = true, nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario creador;

    @JoinColumn(name = "id_subforo", unique = true, nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Subforo subforo;

    public Tema(long id_tema, String titulo, String contenido, Usuario creador, Date fechaCreacion, Subforo subforo) {
        this.id_tema = id_tema;
        this.titulo = titulo;
        this.contenido = contenido;
        this.creador = creador;
        this.fechaCreacion = fechaCreacion;
        this.subforo = subforo;
    }

    public Tema(String titulo, String contenido, Usuario creador, Subforo subforo) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.creador = creador;
        this.fechaCreacion = new Date();
        this.subforo = subforo;
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

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public String getFechaCreacion() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(this.fechaCreacion);
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Subforo getSubforo() {
        return subforo;
    }

    public void setSubforo(Subforo subforo) {
        this.subforo = subforo;
    }
}
