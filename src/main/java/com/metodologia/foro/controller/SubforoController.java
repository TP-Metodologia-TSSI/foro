package com.metodologia.foro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.metodologia.foro.ForoApplication;
import com.metodologia.foro.model.Subforo;
import com.metodologia.foro.model.Tema;
import com.metodologia.foro.persistence.SubforoRepository;
import com.metodologia.foro.persistence.TemaRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/subforo")
public class SubforoController {

    @Autowired
    private SubforoRepository subforoRepository;

    @Autowired
    private TemaRepository temaRepository;


    @GetMapping(value = "/{titulo}")
    public Object index(@PathVariable("titulo") String titulo){

        Object destino = "redirect:/index.html";
        Optional<Subforo> subforoOptional= this.subforoRepository.findByTitulo(titulo);

        if(subforoOptional.isPresent()) {

            Subforo subforo = subforoOptional.get();
            List<Tema> temaList = this.temaRepository.findBySubforo(subforo.getId());

            Object user = "null";
            if(ForoApplication.usuarioLogeado != null) user = ForoApplication.usuarioLogeado;

            ModelAndView modelAndView = new ModelAndView("/tema/index");
            modelAndView.addObject("temaList", temaList);
            modelAndView.addObject("tituloSubforo", titulo);
            modelAndView.addObject("usuarioLoged", user);

            destino = modelAndView;
        }

        return destino;
    }

    @GetMapping(value = "/add.html")
    public Object addView() {
        Object destino = "redirect:/index.html";

        if(ForoApplication.usuarioLogeado != null && ForoApplication.usuarioLogeado.getTipoUsuario() == 1) {
            ModelAndView modelAndView = new ModelAndView("/subforo/index");
            modelAndView.setViewName("/subforo/alta");

            destino = modelAndView;
        }

        return destino;
    }

    @PostMapping(value = "/add")
    public ModelAndView add(String titulo){

        if(ForoApplication.usuarioLogeado != null && ForoApplication.usuarioLogeado.getTipoUsuario() == 1) {

            if(titulo != null && !(titulo.trim().equals(""))) {
                Subforo subforo = new Subforo(titulo);
                this.subforoRepository.save(subforo);
            }
        }
        return new ModelAndView("redirect:/index.html");
    }
}
