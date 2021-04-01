package com.example.demo;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TablonCultivoController {

	@Autowired
	private CultivoRepository repProductos;
	
	
	@PostConstruct
	public void init() {
		repProductos.save(new Cultivo("Trigo","Espelta",LocalDate.of(2019,4,12 ), "zona norte del publo Iniesta" ));
		repProductos.save(new Cultivo("vid","Syrah",LocalDate.of(1999,17,3)));
	}
	
	@RequestMapping("/")
	public String controller(Model model) {
			
		model.addAttribute("tabProductos",repProductos.findAll());
		
		return "TablonProductoFitosanitario.html";
			
	}
	
	
}
