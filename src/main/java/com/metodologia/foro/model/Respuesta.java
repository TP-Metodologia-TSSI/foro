package com.metodologia.foro.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @JoinColumn(name = "id_usuario", unique = true, nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario creador;

    @Column(name = "id_tema", unique = true, nullable = false)
    private long id_tema;

    public Respuesta(long id, String contenido, Date fechaCreacion, Usuario creador, long id_tema) {
        this.id = id;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
        this.creador = creador;
        this.id_tema = id_tema;
    }

    public Respuesta(String contenido, Usuario creador, long id_tema) {
        this.contenido = contenido;
        this.fechaCreacion = new Date();
        this.creador = creador;
        this.id_tema = id_tema;
    }

    public long getId() {
        return id;
    }

    public void setUsuario(Usuario usuario) {
        this.creador = usuario;
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

    public Usuario getCreador() {
        return creador;
    }

    public long getId_tema() {
        return id_tema;
    }

    public void setId_tema(long id_tema) {
        this.id_tema = id_tema;
    }
}
