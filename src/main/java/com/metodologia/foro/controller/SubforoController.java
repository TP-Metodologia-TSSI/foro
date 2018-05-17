package com.metodologia.foro.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.metodologia.foro.entities.Respuesta;
import com.metodologia.foro.entities.Subforo;
import com.metodologia.foro.entities.Tema;
import com.metodologia.foro.response.RespuestaResponseWrapper;
import com.metodologia.foro.response.SubforoResponseWrapper;
import com.metodologia.foro.response.SubforosResponseWrapper;
import com.metodologia.foro.response.TemaResponseWrapper;
import com.metodologia.foro.services.RespuestaService;
import com.metodologia.foro.services.SubforoService;
import com.metodologia.foro.services.TemaService;

@RestController
@RequestMapping(
    value = "/subforo",
    produces = MediaType.APPLICATION_JSON_VALUE
)
public class SubforoController {
	private SubforoService subforoService;
	private TemaService temaService;

	@Autowired
    public SubforoController(SubforoService subforoService, TemaService temaService) {
        this.subforoService = subforoService;
        this.temaService = temaService;
    }
	
	@RequestMapping("/id")
    public @ResponseBody ResponseEntity<SubforoResponseWrapper> getById(@RequestParam("id") Integer id) {
        Subforo s = subforoService.getSubforo(id);
        
        ArrayList<Tema> temas = temaService.temasEnSubforo(id);
        
        ArrayList<TemaResponseWrapper> temasWrapper = new ArrayList();
        
        for (Tema t : temas) {
        	temasWrapper.add(new TemaResponseWrapper(t.getId(), t.getUsuario().getNombreUsuario(), t.getTitulo(), t.getDescripcion(), t.getFecha(), new ArrayList()));
        }
        
        if (null != s) {
            return new ResponseEntity<SubforoResponseWrapper>(new SubforoResponseWrapper(s.getId(), s.getTitulo(), s.getDescripcion(), s.getFecha(), temasWrapper), HttpStatus.OK);
        }
        
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }
	
	@RequestMapping("/")
    public @ResponseBody ResponseEntity<SubforosResponseWrapper> getAll() {
        ArrayList<Subforo> subforos = subforoService.getAll();
        
        ArrayList<SubforoResponseWrapper> subforosWrapper = new ArrayList();
        
        for (Subforo s : subforos) {
        	subforosWrapper.add(new SubforoResponseWrapper(s.getId(), s.getTitulo(), s.getDescripcion(), s.getFecha(), new ArrayList()));
        }
        
        return new ResponseEntity<SubforosResponseWrapper>(new SubforosResponseWrapper(subforosWrapper), HttpStatus.OK);
    }
}
