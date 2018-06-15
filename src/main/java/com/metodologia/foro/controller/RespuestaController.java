package com.metodologia.foro.controller;

import com.metodologia.foro.ForoApplication;
import com.metodologia.foro.model.Respuesta;
import com.metodologia.foro.model.Subforo;
import com.metodologia.foro.model.Tema;
import com.metodologia.foro.persistence.RespuestaRepository;
import com.metodologia.foro.persistence.SubforoRepository;
import com.metodologia.foro.persistence.TemaRepository;
import com.metodologia.foro.persistence.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/respuesta")
public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private TemaRepository temaRepository;

    @Autowired
    private SubforoRepository subforoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping(value = "/add")
    public ModelAndView add(String id_tema, String contenido) {
        Optional<Tema> temaOptional = null;
        Tema tema = null;

        if(!ForoApplication.usuarioLogeado.getName().equals("")) {

            if( Long.parseLong(id_tema) > 0 &&
                contenido != null && !(contenido.trim().equals(""))) {
                temaOptional = this.temaRepository.findById(Long.parseLong(id_tema));

                if(temaOptional.isPresent()) {
                    tema = temaOptional.get();
                    Respuesta respuesta = new Respuesta(contenido, ForoApplication.usuarioLogeado, Long.parseLong(id_tema));
                    this.respuestaRepository.save(respuesta);
                }
            }
        }

        return new ModelAndView("redirect:/index.html");
    }

    @DeleteMapping(value = "/delete")
    public ModelAndView delete(@RequestParam ("id") Long id) {
        Optional<Respuesta> respuestaOptional = this.respuestaRepository.findById(id);

        if(respuestaOptional.isPresent()) {
        	Respuesta respuesta = respuestaOptional.get();

	        if(!ForoApplication.usuarioLogeado.getName().equals("")) {
	        	Tema tema = temaRepository.findById(respuestaOptional.get().getId_tema()).get();
	        	Subforo subforo = tema.getSubforo();
	        	
	        	if (ForoApplication.usuarioLogeado.getId() == respuesta.getCreador().getId() ||
	        			 (ForoApplication.usuarioLogeado.getTipoUsuario() == 1) ||
	        			 subforo.getModerador(ForoApplication.usuarioLogeado.getId())) {
		            this.respuestaRepository.delete(respuesta);
	        	}
	        }
        }

        return new ModelAndView("redirect:/index.html");
    }
    
    @PutMapping(value = "/update")
    public Object update(Long id, String contenido) {
        Object destino = "redirect:/index.html";
        
        Optional<Respuesta> respuestaOptional = this.respuestaRepository.findById(id);

        if(respuestaOptional.isPresent()) {
        	Respuesta respuesta = respuestaOptional.get();

	        if(!ForoApplication.usuarioLogeado.getName().equals("")) {
	        	Tema tema = temaRepository.findById(respuestaOptional.get().getId_tema()).get();
	        	Subforo subforo = tema.getSubforo();
	        	
	        	if (ForoApplication.usuarioLogeado.getId() == respuesta.getCreador().getId() ||
	        			 (ForoApplication.usuarioLogeado.getTipoUsuario() == 1) ||
	        			 subforo.getModerador(ForoApplication.usuarioLogeado.getId())) {
		            this.respuestaRepository.delete(respuesta);
	        	}
	        }
        }
        
        return destino;
    }
    
    @GetMapping(value = "/find/{myString}")
    public Object findWords(@PathVariable("myString") String myString){

        Object destino = "redirect:/index.html";
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        myString = myString.toLowerCase();
        String[] words = myString.toLowerCase().split(" ");
        

        for(Respuesta r : respuestaRepository.findAll()) {
        	String[] elements = new String[3];

        	elements[0] = r.getContenido().toLowerCase();
        	elements[0] = temaRepository.findById(r.getId_tema()).get().getTitulo().toLowerCase();
        	elements[0] = usuarioRepository.findById(r.getCreador().getId()).get().getName().toLowerCase();
        	
    		if (wordsExist(words, elements)) {
    			respuestas.add(r);
	        }
	
	        Object user = "null";
            boolean isLogged = false;

            if(!ForoApplication.usuarioLogeado.getName().equals("")) {
                user = ForoApplication.usuarioLogeado;
                isLogged = true;
            }

            ModelAndView modelAndView = new ModelAndView("/tema/index");
	        modelAndView.addObject("respuestas", respuestas);
	        modelAndView.addObject("busqueda", myString);
            modelAndView.addObject("usuarioLogged", user);
            modelAndView.addObject("isLogged", isLogged);

            destino = modelAndView;
        }

        return destino;
    }
    
    private boolean wordsExist(String[] query, String[] places) {
    	for (String word: query) {
    		boolean isFound = false;
    		for (String place: places) {
    			if (place.toLowerCase().contains(word)) {
    				isFound = true;
    			}
    		}
    		if (isFound == false) {
    			return false;
    		}
    	}
    	
    	return true;
    }
}
