package com.metodologia.foro.controller;

import com.metodologia.foro.entities.Usuario;
import com.metodologia.foro.response.LoginResponseWrapper;
import com.metodologia.foro.services.UsuarioService;
import com.metodologia.foro.utils.SessionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(
    value = "/usuario",
    produces = MediaType.APPLICATION_JSON_VALUE
)
public class UsuarioController {
    private UsuarioService usuarioService;

    private SessionData sessionData;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, SessionData sessionData) {
        this.usuarioService = usuarioService;
        this.sessionData = sessionData;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<LoginResponseWrapper> getById(@RequestParam("user") String nombreUsuario, @RequestParam("pwd") String pwd) {
        Usuario u = usuarioService.login(nombreUsuario, pwd);
        if (null != u) {
            String sessionId = sessionData.addSession(u);
            return new ResponseEntity<LoginResponseWrapper>(new LoginResponseWrapper(sessionId), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping("/logout")
    public @ResponseBody ResponseEntity getById(@RequestHeader("sessionid") String sessionId) {
          sessionData.removeSession(sessionId);
          return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
