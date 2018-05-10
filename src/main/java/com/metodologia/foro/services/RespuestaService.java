package com.metodologia.foro.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.metodologia.foro.entities.Respuesta;
import com.metodologia.foro.persistence.RespuestaDao;

public class RespuestaService {
	RespuestaDao respuestaDao;

    @Autowired
    public RespuestaService(RespuestaDao dao) {
        this.respuestaDao = dao;
    }

    public ArrayList<Respuesta> respuestasEnTema(int idTema) {
    	List<Respuesta> respuestas = respuestaDao.getAll();
    	ArrayList<Respuesta> enTema = new ArrayList();
    	
    	for (Respuesta r : respuestas) {
    		if (r.getTema().getId() == idTema) {
    			enTema.add(r);
    		}
    	}
    	
        return enTema;
    }
}
