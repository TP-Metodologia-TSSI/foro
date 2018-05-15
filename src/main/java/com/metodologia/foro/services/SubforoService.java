package com.metodologia.foro.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.metodologia.foro.entities.Subforo;
import com.metodologia.foro.persistence.SubforoDao;

public class SubforoService {
	SubforoDao dao;

    @Autowired
    public SubforoService(SubforoDao dao) {
        this.dao = dao;
    }

    public ArrayList<Subforo> getAll(int idTema) {
    	List<Subforo> subforos = dao.getAll();
    	ArrayList<Subforo> arraylistSubforos = new ArrayList();
    	
    	arraylistSubforos.addAll(subforos);
    	
        return arraylistSubforos;
    }
    
    public Subforo getSubforo(int id) {
    	List<Subforo> subforos = dao.getAll();
    	
    	for (Subforo sf : subforos) {
    		if (sf.getId() == id) {
    			return sf;
    		}
    	}
    	
    	return null;
    }
}
