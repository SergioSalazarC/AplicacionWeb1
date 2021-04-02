package com.example.demo;

import javax.annotation.PostConstruct;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TablonCultivoController {

	@Autowired
	private CultivoRepository repCultivos;
	
	
	@PostConstruct
	public void init() {
		repCultivos.save(new Cultivo("Trigo","Espelta",new Date(119,4,12 ), "zona norte del publo Iniesta" ));
		repCultivos.save(new Cultivo("vid","Syrah",new Date(98,17,3)));
	}
	
	@RequestMapping("/cultivo")
	public String controller(Model model) {
			
		model.addAttribute("tabCultivos",repCultivos.findAll());
		
		return "tablonCultivos.html";
			
	}
	
	
}
