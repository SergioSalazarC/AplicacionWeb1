package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TablonProductosFitosanitariosController {

	@Autowired
	private ProductoFitosanitarioRepository repProductos;
	
	
	
	
	@RequestMapping("/tablonproductos")
	public String controller(Model model) {
			
		model.addAttribute("tabProductos",repProductos.findAll());
		
		return "tablonProductosFitosanitarios.html";
			
	}
	
	
}
