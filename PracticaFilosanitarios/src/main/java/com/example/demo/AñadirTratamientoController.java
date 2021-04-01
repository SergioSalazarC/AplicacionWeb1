package com.example.demo;

import java.sql.Date;
import java.time.LocalDate;

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
	
	
	@RequestMapping("/AddTratamiento.html")
	public String controller(Model model) {
		model.addAttribute("tabProductos", repProductos.findAll());
		return("AddTratamiento.html");
	}
	
	@RequestMapping("/addTratamiento")
	public String addTrat(
			@RequestParam(value= "producto")long productoId,@RequestParam(value= "numeroLoteFabricacion") String numeroLoteFabricacion,@RequestParam(value= "fechaTratamiento") Date fecha,  Model model) {
		LocalDate fechaTratamiento = LocalDate.of(fecha.getYear(), fecha.getMonth(), fecha.getDay());
		ProductoFitosanitario producto = repProductos.findById(productoId);
		repTratamientos.save(new Tratamiento(producto, numeroLoteFabricacion, fechaTratamiento));
		
		return "mensaje.html";
	}
	
}
