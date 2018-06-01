package com.metodologia.foro.controller;

import com.metodologia.foro.ForoApplication;
import com.metodologia.foro.model.Respuesta;
import com.metodologia.foro.model.Subforo;
import com.metodologia.foro.model.Tema;
import com.metodologia.foro.persistence.RespuestaRepository;
import com.metodologia.foro.persistence.SubforoRepository;
import com.metodologia.foro.persistence.TemaRepository;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tema")
public class TemaController {

    @Autowired
    private TemaRepository temaRepository;

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private SubforoRepository subforoRepository;


    @GetMapping(value = "/{titulo}")
    public Object index(@PathVariable("titulo") String titulo){

        Object destino = "redirect:/subforo/index.html";
        Optional<Tema> temaOptional = this.temaRepository.findByTitulo(titulo);

        if(temaOptional.isPresent()) {
            Tema tema = temaOptional.get();
            List<Respuesta> respuestaList = this.respuestaRepository.findByTema(tema.getId_tema());

            Object user = "null";
            if(ForoApplication.usuarioLogeado != null) user = ForoApplication.usuarioLogeado;

            ModelAndView modelAndView = new ModelAndView("/tema/respuesta");
            modelAndView.addObject("tema", tema);
            modelAndView.addObject("respuestaList", respuestaList);
            modelAndView.addObject("usuarioLoged", user);

            destino = modelAndView;
        }

        return destino;
    }

    @PostMapping(value = "/add.html")
    public Object addView(String nombreSubforo) {

        Object destino = "redirect:/index.html";

        if(ForoApplication.usuarioLogeado != null) {

            Optional<Subforo> subforoOptional = this.subforoRepository.findByTitulo(nombreSubforo);

            if (subforoOptional.isPresent()) {
                Subforo subforo = subforoOptional.get();

                ModelAndView modelAndView = new ModelAndView("/subforo/index");
                modelAndView.setViewName("/tema/alta");
                modelAndView.addObject("id_subforo", subforo.getId());

                destino = modelAndView;
            }
        }

        return destino;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(long id_Subforo, String titulo, String contenido) {

        if(ForoApplication.usuarioLogeado != null) {

            if( id_Subforo > 0 &&
                ForoApplication.usuarioLogeado.getId() > 0 &&
                titulo != null && !(titulo.trim().equals("")) &&
                contenido != null && !(contenido.trim().equals(""))) {

                Tema tema = new Tema(titulo, contenido, ForoApplication.usuarioLogeado.getId(), id_Subforo);
                this.temaRepository.save(tema);
            }
        }

        return new ModelAndView("redirect:/index.html");
    }

    @DeleteMapping(value = "/delete")
    public Object delete(Long id) {
        Object destino = "redirect:/index.html";
        
        Optional<Tema> temaOptional = this.temaRepository.findById(id);

        if (temaOptional.isPresent()) {
	        if(ForoApplication.usuarioLogeado != null && (ForoApplication.usuarioLogeado.getTipoUsuario() == 1 ||
	        		subforoRepository.findById(temaOptional.get().getSubforo()).get().getModerador(ForoApplication.usuarioLogeado.getId()))) {
	        	Tema tema = temaOptional.get();
                this.temaRepository.delete(tema);
	        }
        }
        return destino;
    }
}
