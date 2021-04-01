package com.example.demo;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ActualizarTratamiento {
	
	@Autowired
	private TratamientoRepository repTratamientos;
	@Autowired
	private ProductoFitosanitarioRepository repProductos;
	
	@RequestMapping("/actualizarTratamiento")
	public String controller(@RequestParam(value= "id")long id,
			@RequestParam(value= "producto")long productoId,@RequestParam(value= "numeroLoteFabricacion") String numeroLoteFabricacion,@RequestParam(value= "fechaTratamiento") Date fecha,  Model model) {
			Tratamiento aux = repTratamientos.getOne(id);
			aux.setProducto(repProductos.getOne(productoId));
			aux.setNumeroLoteFabricacion(numeroLoteFabricacion);
			aux.setFechaTratamiento(fecha.toLocalDate());
			repTratamientos.save(aux);
			return "mensaje2.html";
	}

}