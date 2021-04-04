package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditarTratamientoController {
	
	@Autowired
	private TratamientoRepository repTratamientos;
	@Autowired
	private ProductoFitosanitarioRepository repProductos;
	@Autowired
	private CultivoRepository repCultivos;
	
	@RequestMapping("/EditarTratamiento")
	public String controller(@RequestParam int id, Model model) {
			model.addAttribute("tratamiento",repTratamientos.getOne((long) id));
			model.addAttribute("tabProductos", repProductos.findAll());
			model.addAttribute("tabCultivos", repCultivos.findAll());
			return "EditarTratamiento.html";
	}
	
}