package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AñadirCultivoController {
	@Autowired
	private CultivoRepository repCultivo;
	@RequestMapping("/addCultivo")
	public String controller(Cultivo cultivo ,Model model) {
		
		repCultivo.save(cultivo);		
		return "mensaje3.html";
}
	
}
