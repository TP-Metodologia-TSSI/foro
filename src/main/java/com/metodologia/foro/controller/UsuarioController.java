package com.metodologia.foro.controller;

import com.metodologia.foro.ForoApplication;
import com.metodologia.foro.model.Respuesta;
import com.metodologia.foro.model.Tema;
import com.metodologia.foro.model.Usuario;
import com.metodologia.foro.persistence.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.jws.WebParam;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(value = "/login.html")
    public ModelAndView loginView() {
        ModelAndView modelAndView = new ModelAndView("/usuario/login");

        Object user = "null";
        boolean isLogged = false;

        if(!ForoApplication.usuarioLogeado.getName().equals("")) {
            user = ForoApplication.usuarioLogeado;
            isLogged = true;
        }

        modelAndView.addObject("usuarioLoged", user);
        modelAndView.addObject("isLogged", isLogged);

        return modelAndView;
    }

    @GetMapping(value = "/register.html")
    public ModelAndView registerView() {
        ModelAndView modelAndView = new ModelAndView("/usuario/register");

        Object user = "null";
        boolean isLogged = false;

        if(!ForoApplication.usuarioLogeado.getName().equals("")) {
            user = ForoApplication.usuarioLogeado;
            isLogged = true;
        }

        modelAndView.addObject("usuarioLoged", user);
        modelAndView.addObject("isLogged", isLogged);

        return modelAndView;
    }

    @PostMapping(value = "/login")
    public ModelAndView login(String nombre, String password) {

        ModelAndView modelAndView = new ModelAndView("redirect:/usuario/login.html");

        Optional<Usuario> usuario = null;
        usuario = this.usuarioRepository.findByName(nombre);

        if(usuario != null && usuario.get().getPassword().equals(password)) {
            ForoApplication.usuarioLogeado = usuario.get();
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
    
    @GetMapping(value = "/{nombre}")
    public Object index(@PathVariable("nombre") String nombre){

        Object destino = "redirect:/subforo/index.html";
        Optional<Usuario> usuarioOptional = this.usuarioRepository.findByName(nombre);

        if(usuarioOptional.isPresent()) {
        	Usuario usuario = usuarioOptional.get();

            Object user = "null";
            boolean isLogged = false;

            if(!ForoApplication.usuarioLogeado.getName().equals("")) {
                user = ForoApplication.usuarioLogeado;
                isLogged = true;
            }

            ModelAndView modelAndView = new ModelAndView("/usuario/perfil");
            modelAndView.addObject("usuario", usuario);
            modelAndView.addObject("usuarioLoged", user);
            modelAndView.addObject("isLogged", isLogged);

            destino = modelAndView;
        }

        return destino;
    }

    @GetMapping(value = "/logout")
    public ModelAndView logout() {
        ForoApplication.usuarioLogeado = new Usuario(59000, "", "", "", new Date(), 0);
        return new ModelAndView("redirect:/index.html");
    }
}
