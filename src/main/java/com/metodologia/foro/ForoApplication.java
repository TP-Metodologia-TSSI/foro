package com.metodologia.foro;

import com.metodologia.foro.model.Subforo;
import com.metodologia.foro.model.Usuario;
import com.metodologia.foro.persistence.SubforoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@RequestMapping(value = "")
public class ForoApplication {

	@Autowired
	private SubforoRepository subforoRepository;

	public static Usuario usuarioLogeado = new Usuario(100, "", "", "", new Date(), 0);

	public static void main(String[] args) {
		SpringApplication.run(ForoApplication.class, args);
	}

	@GetMapping(value = "/index.html")
	public ModelAndView index(){
		Object user = "null";
		if(usuarioLogeado != null) user = usuarioLogeado;

		List<Subforo> subforoList = this.subforoRepository.findAll();

		ModelAndView modelAndView = new ModelAndView("/subforo/index");
		modelAndView.addObject("subforoList", subforoList);
		modelAndView.addObject("usuarioLoged", user);

		return modelAndView;
	}
}
