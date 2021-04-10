package com.example.demo;

import java.util.List;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TablonTratamientosController {

	@Autowired
	private TratamientoRepository repTratamientos;
	@Autowired
	private CultivoRepository repCultivos;
	
	@PostConstruct
	public void init() {
		
	}
	
	@RequestMapping("/tablontratamientos")
	public String controller(Model model) {
			
		model.addAttribute("tabTratamientos",repTratamientos.findAll());
		
		return "tablonTratamientos.html";
			
	}
	@RequestMapping("/buscarTratamiento")
	public String controller2(@RequestParam(value ="identificador")String id,Model model) {
		List<Tratamiento> resultado=new ArrayList<Tratamiento>();
		Tratamiento t = repTratamientos.findByNumeroLoteFabricacion(id);
		if(t != null) {
			resultado.add(t);	
		}
		List<Cultivo> resultadoAux=new ArrayList<Cultivo>();
		List<Cultivo> consulta1 = new ArrayList<Cultivo>(repCultivos.findByEspecie(id));
		if (!consulta1.isEmpty()) {
			resultadoAux.addAll(consulta1);
		}
		consulta1 = new ArrayList<Cultivo>(repCultivos.findByVariedad(id));
		if (!consulta1.isEmpty()) {
			resultadoAux.addAll(consulta1);
		}
		
		List<Tratamiento> consulta2;
		for (Cultivo c:resultadoAux) {
			consulta2= new ArrayList<Tratamiento>(repTratamientos.findByCultivo(c));
			if (!consulta2.isEmpty()) {
				resultado.addAll(consulta2); 
			}
		}
		try {
			LocalDate fecha = LocalDate.parse(id);
			consulta2 = new ArrayList<Tratamiento>(repTratamientos.findByFechaRecoleccion(fecha));
			if(!consulta2.isEmpty()) {
				resultado.addAll(consulta2);
			}
			consulta2 = new ArrayList<Tratamiento>(repTratamientos.findByFechaReentrada(fecha));
			if(!consulta2.isEmpty()) {
				resultado.addAll(consulta2);
			}
			consulta2 = new ArrayList<Tratamiento>(repTratamientos.findByFechaTratamiento(fecha));
			if(!consulta2.isEmpty()) {
				resultado.addAll(consulta2);
			}
		}catch(DateTimeParseException e) {
			
		}
		if(!resultado.isEmpty()) {
			model.addAttribute("tabTratamientos",resultado);
			return "tablonTratamientos.html";
		}
		else if(id.trim().isEmpty()) {
			resultado = repTratamientos.findAll();
			model.addAttribute("tabTratamientos",resultado);
			return "tablonTratamientos.html";
		}else {
			model.addAttribute("nombre","tratamiento");
			model.addAttribute("id",id);
			return "NotFound.html";
		}
		
	}
	
	
}