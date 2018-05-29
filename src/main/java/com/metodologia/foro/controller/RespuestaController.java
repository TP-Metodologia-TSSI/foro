package com.metodologia.foro.controller;

import com.metodologia.foro.ForoApplication;
import com.metodologia.foro.model.Respuesta;
import com.metodologia.foro.model.Tema;
import com.metodologia.foro.persistence.RespuestaRepository;
import com.metodologia.foro.persistence.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Request;

import java.util.Optional;

@RestController
@RequestMapping(value = "/respuesta")
public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private TemaRepository temaRepository;

    @PostMapping(value = "/add")
    public ModelAndView add(String id_tema, String contenido) {
        Optional<Tema> temaOptional = null;
        Tema tema = null;

        if(ForoApplication.usuarioLogeado != null) {

            if( Long.parseLong(id_tema) > 0 &&
                contenido != null && !(contenido.trim().equals(""))) {
                temaOptional = this.temaRepository.findById(Long.parseLong(id_tema));

                if(temaOptional.isPresent()) {
                    tema = temaOptional.get();
                    Respuesta respuesta = new Respuesta(contenido, ForoApplication.usuarioLogeado.getId(), Long.parseLong(id_tema));
                    this.respuestaRepository.save(respuesta);
                }
            }
        }

        return new ModelAndView("redirect:/index.html");
    }
}
