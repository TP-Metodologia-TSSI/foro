package com.metodologia.foro.controller;

import com.metodologia.foro.ForoApplication;
import com.metodologia.foro.model.Subforo;
import com.metodologia.foro.model.Tema;
import com.metodologia.foro.persistence.SubforoRepository;
import com.metodologia.foro.persistence.TemaRepository;
import com.metodologia.foro.persistence.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private UsuarioRepository usuarioRepository;


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

    @DeleteMapping(value = "/delete")
    public Object delete(Long id) {
        Object destino = "redirect:/index.html";

        if(ForoApplication.usuarioLogeado != null && ForoApplication.usuarioLogeado.getTipoUsuario() == 1) {
            Optional<Subforo> subforoOptional = this.subforoRepository.findById(id);
            
            if(subforoOptional.isPresent()) {
                Subforo subforo = subforoOptional.get();
                this.subforoRepository.delete(subforo);
            }
        }
        return destino;
    }
    
    @PutMapping(value = "/update")
    public Object update(Long id, String titulo) {
    	Object destino = "redirect:/index.html";
        
        System.out.println(id);

        if(ForoApplication.usuarioLogeado != null && ForoApplication.usuarioLogeado.getTipoUsuario() == 1) {
            Optional<Subforo> subforoOptional = this.subforoRepository.findById(id);
            
            if(subforoOptional.isPresent()) {
                Subforo subforo = subforoOptional.get();
                subforo.setName(titulo);
                this.subforoRepository.save(subforo);
            }
        }
        return destino;
    }
    
    @PostMapping(value = "/moderador")
    public Object addMod(Long idUsuario, Long idSubforo){
        Object destino = "redirect:/index.html";

        if(ForoApplication.usuarioLogeado != null && ForoApplication.usuarioLogeado.getTipoUsuario() == 1) {
            if(usuarioRepository.findById(idUsuario).isPresent() && subforoRepository.findById(idSubforo).isPresent()) {
                Subforo subforo = subforoRepository.findById(idSubforo).get();
                subforo.addModerador(usuarioRepository.findById(idUsuario).get());
                this.subforoRepository.save(subforo);
            }
        }
        return destino;
    }
}
