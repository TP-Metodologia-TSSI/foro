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

import com.metodologia.foro.entities.Usuario;
import com.metodologia.foro.response.LoginResponseWrapper;
import com.metodologia.foro.response.RespuestaResponseWrapper;
import com.metodologia.foro.services.RespuestaService;
import com.metodologia.foro.utils.SessionData;

@RestController
@RequestMapping(
    value = "/respuesta",
    produces = MediaType.APPLICATION_JSON_VALUE
)
public class RespuestaController {
	private RespuestaService respuestaService;

    private SessionData sessionData;

    @Autowired
    public RespuestaController(RespuestaService respuestaService, SessionData sessionData) {
        this.respuestaService = respuestaService;
        this.sessionData = sessionData;
    }

    @RequestMapping("/")
    public @ResponseBody ResponseEntity<RespuestaResponseWrapper> getById(@RequestParam("id") Integer id) {
        Respuesta r = respuestaService.getRespuesta(id);
        if (null != u) {
            String sessionId = sessionData.addSession(u);
            return new ResponseEntity<RespuestaResponseWrapper>(new RespuestaResponseWrapper(sessionId), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }
}
