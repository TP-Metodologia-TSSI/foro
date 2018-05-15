package com.metodologia.foro.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RespuestaResponseWrapper {
	@JsonProperty
    private int id;
	@JsonProperty
    private int id_usuario;
	@JsonProperty
    private int id_tema;
	@JsonProperty
    private String contenido;
	@JsonProperty
    private Date fecha;

    public RespuestaResponseWrapper(int id, int id_usuario, int id_tema, String contenido, Date fecha) {
    	this.id = id;
    	this.id_usuario = id_usuario;
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

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
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
