package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AĆ±adirProductoFitosanitarioController {
	
	@Autowired
	private ProductoFitosanitarioRepository repProductos;
	
	
	@RequestMapping("/addProducto")
	public String controller(ProductoFitosanitario producto ,Model model) {
			
			repProductos.save(producto);		
			return "mensaje.html";
	}
	
}
