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
	
	
	
	@RequestMapping("/tabloncultivos")
	public String controller(Model model) {
			
		model.addAttribute("tabCultivos",repCultivos.findAll());
		
		return "tablonCultivos.html";
			
	}
	
	
}
