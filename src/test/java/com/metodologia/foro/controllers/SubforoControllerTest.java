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

import com.metodologia.foro.controller.SubforoController;
import com.metodologia.foro.controller.UsuarioController;
import com.metodologia.foro.model.Subforo;
import com.metodologia.foro.model.Usuario;
import com.metodologia.foro.persistence.SubforoRepository;
import com.metodologia.foro.persistence.UsuarioRepository;

public class SubforoControllerTest {
    @Mock
    RestTemplate restTemplate;
    @Mock
    SubforoRepository subforos;
    @Mock
    UsuarioRepository usuarios;

    @InjectMocks
    SubforoController controller;
    UsuarioController uController;

    ModelAndView modelAndView;
    HttpServletRequest request;
    HttpSession session;

    Usuario usuario = new Usuario(1, "admin", "1234", "admin.png", new Date(), 1);

    @Before
	    public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.modelAndView = new ModelAndView();
		this.request = mock(HttpServletRequest.class);
		this.session = new MockHttpSession();
	
		usuarios.save(usuario);
    }

    @Test
    public void insertOkTest() {
		uController.login("admin", "1234");
		ModelAndView modelAndView = this.controller.add("NewSub");
		
		Subforo subforo = (Subforo) modelAndView.getModel().get("subforo");
		
		assertEquals(subforo.getName(), "NewSub");
		assertEquals(modelAndView.getViewName() == "redirect:/index.html", true);
    }
}
