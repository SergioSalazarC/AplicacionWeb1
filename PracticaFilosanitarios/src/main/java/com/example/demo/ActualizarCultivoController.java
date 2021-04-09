package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ActualizarCultivoController {
	@Autowired
	private CultivoRepository repCultivo;
	@RequestMapping("/actualizarCultivo")
	public String controller(Cultivo recogido,Model model) {
		Cultivo aux = repCultivo.getOne(recogido.getId());
		aux.setEspecie(recogido.getEspecie());
		aux.setVariedad(recogido.getVariedad());
		aux.setZona(recogido.getZona());
		aux.setPlantado(recogido.getPlantado());
		/*aux.setTratamientos(recogido.getTratamientos());*/ 
		repCultivo.save(aux);
		return "mensaje6.html"; 
	}
}