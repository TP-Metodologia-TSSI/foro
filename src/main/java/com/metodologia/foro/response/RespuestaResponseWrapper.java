package com.metodologia.foro.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RespuestaResponseWrapper {
	@JsonProperty
    private int id;
	@JsonProperty
    private String nombre_usuario;
	@JsonProperty
    private int id_tema;
	@JsonProperty
    private String contenido;
	@JsonProperty
    private Date fecha;

    public RespuestaResponseWrapper(int id, String nombre_usuario, int id_tema, String contenido, Date fecha) {
    	this.id = id;
    	this.nombre_usuario = nombre_usuario;
    	this.id_tema = id_tema;
    	this.contenido = contenido;
    	this.fecha = fecha;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getId_usuario() {
		return nombre_usuario;
	}

	public void setId_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public int getId_tema() {
		return id_tema;
	}

	public void setId_tema(int id_tema) {
		this.id_tema = id_tema;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
}
