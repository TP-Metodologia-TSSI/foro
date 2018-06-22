package com.metodologia.foro.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.metodologia.foro.controller.RespuestaController;
import com.metodologia.foro.controller.TemaController;
import com.metodologia.foro.model.Subforo;
import com.metodologia.foro.model.Tema;
import com.metodologia.foro.model.Usuario;
import com.metodologia.foro.persistence.RespuestaRepository;
import com.metodologia.foro.persistence.SubforoRepository;
import com.metodologia.foro.persistence.TemaRepository;
import com.metodologia.foro.persistence.UsuarioRepository;

public class RespuestaControllerTest {
    @Mock
    RestTemplate restTemplate;
    @Mock
    SubforoRepository subforos;
    @Mock
    TemaRepository temas;
    @Mock
    RespuestaRepository respuestas;
    @Mock
    UsuarioRepository usuarios;

    @InjectMocks
    RespuestaController controller;

    ModelAndView modelAndView;
    HttpServletRequest request;
    HttpSession session;

    Usuario usuario = new Usuario(1, "admin", "1234", "admin.png", new Date(), 1);
    Subforo subforo = new Subforo(1, "subforo", new Date());
    Tema tema = new Tema("Tema", "Mycontent", usuario, subforo);

    @Before
    public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.modelAndView = new ModelAndView();
		this.request = mock(HttpServletRequest.class);
		this.session = new MockHttpSession();
	
		usuarios.save(usuario);
		subforos.save(subforo);
		temas.save(tema);
    }

    @Test
    public void insertOkTest() {
		ModelAndView modelAndView = this.controller.add("1", "MyRespuesta");

		assertEquals(modelAndView.getViewName() == "redirect:/index.html", true);
    }
}
