package com.metodologia.foro.controller;

import com.metodologia.foro.ForoApplication;
import com.metodologia.foro.model.Usuario;
import com.metodologia.foro.persistence.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(value = "/login.html")
    public ModelAndView loginView() {
        ModelAndView modelAndView = new ModelAndView("/usuario/login");
        return modelAndView;
    }

    @GetMapping(value = "/register.html")
    public ModelAndView registerView() {
        ModelAndView modelAndView = new ModelAndView("/usuario/register");
        return modelAndView;
    }

    @PostMapping(value = "/login")
    public ModelAndView login(String nombre, String password) {

        ModelAndView modelAndView = new ModelAndView("redirect:/usuario/login.html");

        Usuario usuario = null;
        usuario = this.usuarioRepository.findByName(nombre);

        if(usuario != null && usuario.getPassword().equals(password)) {
            ForoApplication.usuarioLogeado = usuario;
            modelAndView.setViewName("redirect:/index.html");
        }

        return modelAndView;
    }

    @PostMapping(value = "/register")
    public ModelAndView register(String name, String email, String password) {

        ModelAndView modelAndView = new ModelAndView("redirect:/usuario/register.html");

        if( name != null && !(name.trim().equals("")) &&
            password != null && !(password.trim().equals(""))) {

            Usuario usuario = new Usuario(name, password,"");
            this.usuarioRepository.save(usuario);
            modelAndView.setViewName("redirect:/usuario/login.html");
        }

        return modelAndView;
    }

    @GetMapping(value = "/logout")
    public ModelAndView logout() {

        if(ForoApplication.usuarioLogeado != null) {
            ForoApplication.usuarioLogeado = null;
        }

        return new ModelAndView("redirect:/index.html");
    }
}
