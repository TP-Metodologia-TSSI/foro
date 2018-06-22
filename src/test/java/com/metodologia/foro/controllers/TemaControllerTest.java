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
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.metodologia.foro.controller.TemaController;
import com.metodologia.foro.model.Subforo;
import com.metodologia.foro.model.Tema;
import com.metodologia.foro.model.Usuario;
import com.metodologia.foro.persistence.SubforoRepository;
import com.metodologia.foro.persistence.TemaRepository;
import com.metodologia.foro.persistence.UsuarioRepository;

public class TemaControllerTest {
    @Mock
    RestTemplate restTemplate;
    @Mock
    SubforoRepository subforos;
    @Mock
    TemaRepository temas;
    @Mock
    UsuarioRepository usuarios;

    @InjectMocks
    TemaController controller;

    ModelAndView modelAndView;
    HttpServletRequest request;
    HttpSession session;

    Usuario usuario = new Usuario(1, "admin", "1234", "admin.png", new Date(), 1);
    Subforo subforo = new Subforo(1, "subforo", new Date());

    @Before
    public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.modelAndView = new ModelAndView();
		this.request = mock(HttpServletRequest.class);
		this.session = new MockHttpSession();
	
		usuarios.save(usuario);
		subforos.save(subforo);
    }

    @Test
    public void insertOkTest() {
		long id = 1;
		ModelAndView modelAndView = this.controller.add(id, "mytema", "mycontenido");

		assertEquals(modelAndView.getViewName() == "redirect:/index.html", true);
    }
}
