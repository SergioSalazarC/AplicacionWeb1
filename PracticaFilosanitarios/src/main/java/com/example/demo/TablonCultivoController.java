package com.example.demo;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TablonCultivoController {

	@Autowired
	private CultivoRepository repCultivos;
  
	@RequestMapping("/tabloncultivos")
	public String controller(Model model) {
			
		model.addAttribute("tabCultivos",repCultivos.findAll());

		return "tablonCultivos.html";
	}
	@RequestMapping("/buscarCultivo")
	public String controller2(@RequestParam(value ="identificador")String id,Model model) {
		List<Cultivo> resultado;
		if (id!="") {
			resultado = repCultivos.findByEspecie(id);
			resultado.addAll(repCultivos.findByVariedad(id));
		}else {
			resultado = repCultivos.findAll();
		}
		model.addAttribute("tabCultivos",resultado);
		return "tablonCultivos.html";
	}
	
	
}
