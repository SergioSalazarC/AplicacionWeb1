package com.example.demo;

import java.sql.Date;
import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {

	@Autowired
	private ProductoFitosanitarioRepository repProductos;
	@Autowired
	private CultivoRepository repCultivos;
	@Autowired
	private TratamientoRepository repTratamientos;
	
	
	
	@PostConstruct
	public void init() {
		ProductoFitosanitario producto1 = new ProductoFitosanitario("producto1",1,2);
		repProductos.save(producto1);
		repProductos.save(new ProductoFitosanitario("producto2","Descripcion del producto 2",3,4));
		Cultivo cultivo1 = new Cultivo("Trigo","Espelta",new Date(119,4,12 ), "zona norte del pueblo Iniesta" );
		repCultivos.save(cultivo1);
		repCultivos.save(new Cultivo("vid","Syrah",new Date(98,17,3)));
		Tratamiento tratamiento1 = new Tratamiento(cultivo1, producto1, "1234AAA", LocalDate.of(2000, 8, 23));
		repTratamientos.save(tratamiento1);
		cultivo1.addTratamiento(tratamiento1);
	}
	
	@RequestMapping("/")
	public String controller(Model model) {
		
		return "MainPage.html";
			
	}
	
	
}
