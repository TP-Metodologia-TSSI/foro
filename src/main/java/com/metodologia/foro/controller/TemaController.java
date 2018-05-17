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
import com.metodologia.foro.entities.Tema;
import com.metodologia.foro.response.RespuestaResponseWrapper;
import com.metodologia.foro.response.TemaResponseWrapper;
import com.metodologia.foro.services.RespuestaService;
import com.metodologia.foro.services.TemaService;
import com.metodologia.foro.utils.SessionData;

@RestController
@RequestMapping(
    value = "/tema",
    produces = MediaType.APPLICATION_JSON_VALUE
)
public class TemaController {
	private RespuestaService respuestaService;
	private TemaService temaService;

    @Autowired
    public TemaController(RespuestaService respuestaService, TemaService temaService) {
        this.respuestaService = respuestaService;
        this.temaService = temaService;
    }
    
    @RequestMapping("/")
    public @ResponseBody ResponseEntity<TemaResponseWrapper> getById(@RequestParam("id") Integer id) {
        Tema t = temaService.getTema(id);
        
        ArrayList<Respuesta> respuestas = respuestaService.respuestasEnTema(id);
        
        ArrayList<RespuestaResponseWrapper> respuestasWrapper = new ArrayList();
        
        for (Respuesta r : respuestas) {
        	respuestasWrapper.add(new RespuestaResponseWrapper(r.getId(), r.getUsuario().getNombreUsuario(), r.getTema().getId(), r.getContenido(), r.getFecha()));
        }
        
        if (null != t) {
            return new ResponseEntity<TemaResponseWrapper>(new TemaResponseWrapper(t.getId(), t.getUsuario().getNombreUsuario(), t.getTitulo(), t.getDescripcion(), t.getFecha(), respuestasWrapper), HttpStatus.OK);
        }
        
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }
}
