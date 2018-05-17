package com.metodologia.foro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.metodologia.foro.entities.Respuesta;
import com.metodologia.foro.response.RespuestaResponseWrapper;
import com.metodologia.foro.services.RespuestaService;

@RestController
@RequestMapping(
    value = "/respuesta",
    produces = MediaType.APPLICATION_JSON_VALUE
)
public class RespuestaController {
	private RespuestaService respuestaService;

    @Autowired
    public RespuestaController(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }

    @RequestMapping("/")
    public @ResponseBody ResponseEntity<RespuestaResponseWrapper> getById(@RequestParam("id") Integer id) {
        Respuesta r = respuestaService.getRespuesta(id);
        if (null != r) {
            return new ResponseEntity<RespuestaResponseWrapper>(new RespuestaResponseWrapper(r.getId(), r.getUsuario().getNombreUsuario(), r.getTema().getId(), r.getContenido(), r.getFecha()), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }
}
