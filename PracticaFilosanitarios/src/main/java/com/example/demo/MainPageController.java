package com.example.demo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
		List<ProductoFitosanitario> productos = new ArrayList();
		productos.add(new ProductoFitosanitario("producto1",1,2));
		productos.add(new ProductoFitosanitario("producto2","Descripcion del producto 2",3,4));
		productos.add(new ProductoFitosanitario("producto3", "Descripción del producto 3", 120, 275));
		productos.add(new ProductoFitosanitario("producto4", 0, 34));
		productos.add(new ProductoFitosanitario("producto5", 0, 0));
		repProductos.saveAll(productos);
		
		
		List<Cultivo> cultivos = new ArrayList();
		cultivos.add(new Cultivo("Trigo","Espelta",new Date(119,4,12 ), "zona norte del pueblo Iniesta" ));
		cultivos.add(new Cultivo("Vid","Syrah",new Date(98,17,3)));
		cultivos.add(new Cultivo("Maiz","Amarillo", new Date(100, 23, 7),"Zona sur de Missisipi"));
		cultivos.add(new Cultivo("Uva","Boval", new Date(112, 12, 4), "La Mancha"));
		cultivos.add(new Cultivo("Almendra","Pequeña", new Date(101, 11, 1)));
		cultivos.add(new Cultivo("Oliva", "Negra", new Date(73, 12, 4), "Jaen"));
		repCultivos.saveAll(cultivos);
		
		List<Tratamiento> tratamientos = new ArrayList();
		tratamientos.add(new Tratamiento(cultivos.get(0), productos.get(3), "1234AAA",LocalDate.of(2020, 5, 8)));
		repTratamientos.save(tratamientos.get(0));
		cultivos.get(0).addTratamiento(tratamientos.get(0));
		tratamientos.add(new Tratamiento(cultivos.get(0), productos.get(0), "123123VASF", LocalDate.of(2020, 5, 8)));
		repTratamientos.save(tratamientos.get(1));
		cultivos.get(0).addTratamiento(tratamientos.get(1));
		tratamientos.add(new Tratamiento(cultivos.get(0), productos.get(1), "961894EWQE", LocalDate.of(2020, 5, 8)));
		repTratamientos.save(tratamientos.get(2));
		cultivos.get(0).addTratamiento(tratamientos.get(2));
		
		tratamientos.add(new Tratamiento(cultivos.get(1), productos.get(0), "16189AEF", LocalDate.of(2002, 7, 8)));
		repTratamientos.save(tratamientos.get(3));
		cultivos.get(1).addTratamiento(tratamientos.get(3));
		tratamientos.add(new Tratamiento(cultivos.get(1), productos.get(2), "EOWNE23", LocalDate.of(1998, 9, 23)));
		repTratamientos.save(tratamientos.get(4));
		cultivos.get(1).addTratamiento(tratamientos.get(4));
		
		tratamientos.add(new Tratamiento(cultivos.get(2), productos.get(2), "1941QWE", LocalDate.of(2001, 7, 7)));
		repTratamientos.save(tratamientos.get(5));
		cultivos.get(2).addTratamiento(tratamientos.get(5));
		
		tratamientos.add(new Tratamiento(cultivos.get(3), productos.get(3), "AFNOWOE123", LocalDate.of(2013, 12, 10)));
		repTratamientos.save(tratamientos.get(6));
		cultivos.get(3).addTratamiento(tratamientos.get(6));
		
		tratamientos.add(new Tratamiento(cultivos.get(4), productos.get(4), "186787ZSW", LocalDate.of(2008, 12, 31)));
		repTratamientos.save(tratamientos.get(6));
		cultivos.get(3).addTratamiento(tratamientos.get(6));
	}
	
	@RequestMapping("/")
	public String controller(Model model) {
		
		return "MainPage.html";
			
	}
	
	
}
