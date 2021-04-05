package com.example.demo;

import java.sql.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {

	@Autowired
	private ProductoFitosanitarioRepository repProductos;
	@Autowired
	private CultivoRepository repCultivos;
	@Autowired
	private TratamientoRepository repTratamientos;
	
	
	
	@PostConstruct
	public void init() {
		repProductos.save(new ProductoFitosanitario("producto1",1,2));
		repProductos.save(new ProductoFitosanitario("producto2","Descripcion del producto 2",3,4));
		repCultivos.save(new Cultivo("Trigo","Espelta",new Date(119,4,12 ), "zona norte del publo Iniesta" ));
		repCultivos.save(new Cultivo("vid","Syrah",new Date(98,17,3)));
	}
	
	@RequestMapping("/")
	public String controller(Model model) {
		
		return "Página-1.html";
			
	}
	
	
}
