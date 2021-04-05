package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TablonTratamientosController {

	@Autowired
	private TratamientoRepository repTratamientos;
	
	
	@PostConstruct
	public void init() {
		
	}
	
	@RequestMapping("/tablontratamientos")
	public String controller(Model model) {
			
		model.addAttribute("tabTratamientos",repTratamientos.findAll());
		
		return "tablonTratamientos.html";
			
	}
	
	
}