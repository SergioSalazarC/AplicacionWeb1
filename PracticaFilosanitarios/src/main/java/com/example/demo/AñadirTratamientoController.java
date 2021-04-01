package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AñadirTratamientoController {
	@Autowired
	private ProductoFitosanitarioRepository repProductos;
	
	
	@RequestMapping("/AddTratamiento")
	public String controller(Model model) {
		model.addAttribute("tabProductos", repProductos.findAll());
		return("AddTratamiento.html");
	}
	
}
