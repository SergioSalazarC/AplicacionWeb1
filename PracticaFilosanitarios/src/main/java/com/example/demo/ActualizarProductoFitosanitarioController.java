package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ActualizarProductoFitosanitarioController {
	
	@Autowired
	private ProductoFitosanitarioRepository repProductos;
	
	@RequestMapping("/actualizarProducto")
	public String controller(ProductoFitosanitario recogido,  Model model) {
			ProductoFitosanitario aux = repProductos.getOne(recogido.getId());
			aux.setNombre(recogido.getNombre());
			aux.setDescripcion(recogido.getDescripcion());
			aux.setPlazoDeRecoleccion(recogido.getPlazoDeRecoleccion());
			aux.setPlazoDeReentrada(recogido.getPlazoDeReentrada());
			repProductos.save(aux);
			
			return "mensaje2.html";
			
	}

}
