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

import com.metodologia.foro.entities.Subforo;
import com.metodologia.foro.response.LoginResponseWrapper;
import com.metodologia.foro.utils.SessionData;

@RestController
@RequestMapping(
    value = "/subforo",
    produces = MediaType.APPLICATION_JSON_VALUE
)

public class SubforoController {

	private SubforoService SubforoService;

	private SessionData sessionData;

	@Autowired
	public SubforoController(SubforoService subforoService, SessionData sessionData) {
        this.subforoService = subforoService;
        this.sessionData = sessionData;
	}

	@RequestMapping("/")
	public @ResponseBody ResponseEntity<SubforoResponseWrapper> getById(@RequestParam("id") Integer id) {
		Subforo s = subforoService.getSubforo(id);
		if (null != s) {
            String sessionId = sessionData.addSession(s);
            return new ResponseEntity<SubforoResponseWrapper>(new subforoResponseWrapper(sessionId), HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.UNAUTHORIZED);
	}

}