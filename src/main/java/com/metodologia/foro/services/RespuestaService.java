package com.metodologia.foro.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.metodologia.foro.entities.Respuesta;
import com.metodologia.foro.persistence.RespuestaDao;

public class RespuestaService {
	RespuestaDao dao;

    @Autowired
    public RespuestaService(RespuestaDao dao) {
        this.dao = dao;
    }

    public ArrayList<Respuesta> respuestasEnTema(int idTema) {
    	List<Respuesta> respuestas = dao.getAll();
    	ArrayList<Respuesta> enTema = new ArrayList();
    	
    	for (Respuesta r : respuestas) {
    		if (r.getTema().getId() == idTema) {
    			enTema.add(r);
    		}
    	}
    	
        return enTema;
    }
    
    public Respuesta getRespuesta(int id) {
    	List<Respuesta> respuestas = dao.getAll();
    	
    	for (Respuesta r : respuestas) {
    		if (r.getId() == id) {
    			return r;
    		}
    	}
    	
    	return null;
    }
}
