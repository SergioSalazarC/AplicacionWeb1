package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditarProductoFitosanitarioController {
	
	@Autowired
	private ProductoFitosanitarioRepository repProductos;
	
	@RequestMapping("/EditarProducto")
	public String controller(@RequestParam int id, Model model) {
			model.addAttribute("producto",repProductos.getOne((long) id));
			
			return "EditarProductoFitosanitario.html";
			
	}
	
}
