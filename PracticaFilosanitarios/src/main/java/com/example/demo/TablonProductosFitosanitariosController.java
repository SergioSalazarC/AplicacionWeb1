package com.example.demo;

import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.lang.NumberFormatException; 
@Controller
public class TablonProductosFitosanitariosController {

	@Autowired
	private ProductoFitosanitarioRepository repProductos; 
	
	
	
	
	@RequestMapping("/tablonproductos")
	public String controller(Model model) {
			
		model.addAttribute("tabProductos",repProductos.findAll());
		
		return "tablonProductosFitosanitarios.html";
			
	}
	@RequestMapping("/buscarProducto")
	public String controller2(@RequestParam(value ="identificador")String id,Model model) {
		List<ProductoFitosanitario> resultado = new ArrayList<ProductoFitosanitario>();
		ProductoFitosanitario consulta1 = repProductos.findByNombre(id);
		try {
			int numero=Integer.parseInt(id);
			ProductoFitosanitario consulta2 = repProductos.findByPlazoDeRecoleccion(numero);
			ProductoFitosanitario consulta3 = repProductos.findByPlazoDeReentrada(numero);
			if ( consulta2 != null  ) {
				resultado.add(consulta2);
			}
			if(consulta3 != null) {
				resultado.add(consulta3 );
			}
		} 
		catch(NumberFormatException e) {
			
		}
		if(consulta1 != null) {
			resultado.add(consulta1);
			model.addAttribute("tabProductos",resultado);
			return "tablonProductosFitosanitarios.html";
		}else if(!resultado.isEmpty()) {
			model.addAttribute("tabProductos",resultado);
			return "tablonProductosFitosanitarios.html";
		}else if(id.trim().isEmpty()) {
			resultado = repProductos.findAll();
			model.addAttribute("tabProductos",resultado);
			return "tablonProductosFitosanitarios.html";
		}else {
			model.addAttribute("nombre","producto fitosanitario");
			model.addAttribute("id",id);
			return "NotFound.html";
		}
		
		
	}
	
	
}
