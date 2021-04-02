package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class EditarCultivoController {
	@Autowired
	private CultivoRepository repCultivos;
	
	@RequestMapping("/EditarCultivo")
	public String controller(@RequestParam int id, Model model) {
			model.addAttribute("cultivo",repCultivos.getOne((long) id));
			
			return "EditarCultivo.html";
			
	}
}
