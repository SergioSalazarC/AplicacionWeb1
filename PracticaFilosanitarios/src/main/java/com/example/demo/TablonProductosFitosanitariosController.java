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
	
	
	@PostConstruct
	public void init() {
		repProductos.save(new ProductoFitosanitario("producto1",30,30));
		repProductos.save(new ProductoFitosanitario("producto2","Descripcion no vacia",30,30));
	}
	
	@RequestMapping("/")
	public String controller(Model model) {
			
		

		
		model.addAttribute("tabProductos",repProductos.findAll());
		
		return "TablonProductoFitosanitario.html";
			
	}
	
	
}
