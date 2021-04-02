package com.example.demo;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class AñadirCultivoController {
	@Autowired
	private CultivoRepository repCultivo;
	@RequestMapping("/AddCultivo")
	public String controller(Cultivo cultivo ,Model model) {
		
		repCultivo.save(cultivo);		
		return "mensaje3.html";
}
	
}
