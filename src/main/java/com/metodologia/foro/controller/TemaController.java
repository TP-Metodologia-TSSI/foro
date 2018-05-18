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

import com.metodologia.foro.entities.Tema;
import com.metodologia.foro.response.LoginResponseWrapper;
import com.metodologia.foro.utils.SessionData;

@RestController
@RequestMapping(
    value = "/tema",
    produces = MediaType.APPLICATION_JSON_VALUE
)

public class TemaController {
	private TemaService temaService;

    private SessionData sessionData;

	@Autowired
	public TemaController(TemaService temaService, SessionData sessionData) {
        this.temaService = temaService;
        this.sessionData = sessionData;
	}

	@RequestMapping("/")
    public @ResponseBody ResponseEntity<TemaResponseWrapper> getById(@RequestParam("id") Integer id) {
        Tema t = temaService.getTema(id);
        if (null != t) {
            String sessionId = sessionData.addSession(t);
            return new ResponseEntity<TemResponseWrapper>(new TemaResponseWrapper(sessionId), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
	}
}