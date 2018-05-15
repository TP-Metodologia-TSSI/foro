package com.metodologia.foro.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.metodologia.foro.entities.Tema;
import com.metodologia.foro.persistence.TemaDao;

public class TemaService {
	TemaDao dao;

    @Autowired
    public TemaService(TemaDao dao) {
        this.dao = dao;
    }

    public ArrayList<Tema> temasEnSubforo(int idSubforo) {
    	List<Tema> temas = dao.getAll();
    	ArrayList<Tema> enSubforo = new ArrayList();
    	
    	for (Tema t : temas) {
    		if (t.getSubforo().getId() == idSubforo) {
    			enSubforo.add(t);
    		}
    	}
    	
        return enSubforo;
    }
    
    public Tema getTema(int id) {
    	List<Tema> temas = dao.getAll();
    	
    	for (Tema t : temas) {
    		if (t.getId() == id) {
    			return t;
    		}
    	}
    	
    	return null;
    }
}
