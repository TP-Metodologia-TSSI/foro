package com.metodologia.foro.controllers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.metodologia.foro.controller.UsuarioController;
import com.metodologia.foro.model.Usuario;
import com.metodologia.foro.persistence.UsuarioRepository;

import junit.framework.TestCase;

public class UsuarioControllerTest extends TestCase {
    @Mock
    RestTemplate restTemplate;
    @Mock
    UsuarioRepository usuarios;

    @InjectMocks
    UsuarioController controller;

    ModelAndView modelAndView;
    HttpServletRequest request;
    HttpSession session;

    @Before
    public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.modelAndView = new ModelAndView();
		this.request = mock(HttpServletRequest.class);
		this.session = new MockHttpSession();
		
		usuarios.save(new Usuario("admin", "1234", "admin.png"));
    }

    @Test
    public void registerOKTest() {
		ModelAndView modelAndView = this.controller.register("admin2", "1234", "admin.png");
		assertEquals(modelAndView.getStatus(), HttpStatus.OK);
		assertEquals(modelAndView.getViewName(), "redirect:/usuario/login.html");
    }

    @Test
    public void registerEmptyTest() {	
		ModelAndView modelAndView = this.controller.register("", "", "");
		assertEquals(modelAndView.getStatus(), HttpStatus.NO_CONTENT);
		assertEquals(modelAndView.getViewName(), "redirect:/usuario/register.html");
    }

    @Test
    public void loginOKTest() {
		when(this.request.getSession(true)).thenReturn(this.session);

		ModelAndView modelAndView = this.controller.login("admin", "1234");
		
		assertEquals(modelAndView.getStatus(), HttpStatus.OK);
		assertEquals(modelAndView.getViewName(), "redirect:/index");
		assertEquals(modelAndView.getModel().get("isLogged"), true);
    }

    @Test
    public void loginBadTest() {
		ModelAndView modelAndView = this.controller.login("admin", "");		

		assertEquals(modelAndView.getStatus(), HttpStatus.OK);
		assertEquals(modelAndView.getViewName(), "redirect:/usuario/login.html");
		assertEquals(modelAndView.getModel().get("isLogged"), true);
    }

    @Test
    public void logoutTest() {
		this.session.setAttribute("token", "dasdsd555");
		when(this.request.getSession(true)).thenReturn(this.session);

		ModelAndView modelAndView = this.controller.logout();

		assertEquals(modelAndView.getViewName(), "redirect:/usuario/login.html");
		assertEquals(modelAndView.getStatus(), HttpStatus.OK);
    }
}
