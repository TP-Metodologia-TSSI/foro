package com.metodologia.foro.response;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubforoResponseWrapper {
	@JsonProperty
    private int id;
	@JsonProperty
    private String titulo;
	@JsonProperty
    private String descripcion;
	@JsonProperty
    private Date fecha;
	@JsonProperty
    private ArrayList<TemaResponseWrapper> temas;

    public SubforoResponseWrapper(int id, String titulo, String descripcion, Date fecha, ArrayList<TemaResponseWrapper> temas) {
    	this.id = id;
    	this.titulo = titulo;
    	this.descripcion = descripcion;
    	this.fecha = fecha;
    	this.temas = temas;
    }

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public ArrayList<TemaResponseWrapper> getTemas() {
		return temas;
	}
}
