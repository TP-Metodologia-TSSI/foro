package com.metodologia.foro.response;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TemaResponseWrapper {
	@JsonProperty
    private int id;
	@JsonProperty
    private String nombre_usuario;
	@JsonProperty
    private String titulo;
	@JsonProperty
    private String descripcion;
	@JsonProperty
    private Date fecha;
	@JsonProperty
    private ArrayList<RespuestaResponseWrapper> respuestas;

    public TemaResponseWrapper(int id, String nombre_usuario, String titulo, String descripcion, Date fecha, ArrayList<RespuestaResponseWrapper> respuestas) {
    	this.id = id;
    	this.nombre_usuario = nombre_usuario;
    	this.titulo = titulo;
    	this.descripcion = descripcion;
    	this.fecha = fecha;
    	this.respuestas = respuestas;
    }

	public int getId() {
		return id;
	}

	public String getId_usuario() {
		return nombre_usuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
