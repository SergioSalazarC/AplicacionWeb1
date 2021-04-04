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
		repProductos.save(new ProductoFitosanitario("producto1",1,2));
		repProductos.save(new ProductoFitosanitario("producto2","Descripcion del producto 2",3,4));
	}
	
	@RequestMapping("/")
	public String controller(Model model) {
			
		model.addAttribute("tabProductos",repProductos.findAll());
		
		return "tablonProductoFitosanitario.html";
			
	}
	
	
}
