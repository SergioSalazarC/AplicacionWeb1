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
public class AñadirTratamientoController {
	@Autowired
	private ProductoFitosanitarioRepository repProductos;
	@Autowired
	private TratamientoRepository repTratamientos;
	@Autowired
	private CultivoRepository repCultivos;
	
	
	@RequestMapping("/AddTratamiento.html")
	public String controller(Model model) {
		model.addAttribute("tabProductos", repProductos.findAll());
		model.addAttribute("tabCultivos", repCultivos.findAll());
		return("AddTratamiento.html");
	}
	
	@RequestMapping("/addTratamiento")
	public String addTrat(
			@RequestParam(value= "cultivo")long cultivoId,
			@RequestParam(value= "producto")long productoId,@RequestParam(value= "numeroLoteFabricacion") String numeroLoteFabricacion,@RequestParam(value= "fechaTratamiento") Date fecha,  Model model) {
		LocalDate fechaTratamiento = fecha.toLocalDate();
		Cultivo cultivo = repCultivos.getOne(cultivoId);
		ProductoFitosanitario producto = repProductos.getOne(productoId);
		Tratamiento tratamiento = new Tratamiento(cultivo, producto, numeroLoteFabricacion, fechaTratamiento);
		repTratamientos.save(tratamiento);
		cultivo.addTratamiento(tratamiento);
		repCultivos.save(cultivo);
		return "mensaje.html";
	}
}
