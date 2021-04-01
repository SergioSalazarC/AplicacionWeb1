package com.example.demo;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TratamientoRepository  extends JpaRepository<Tratamiento, Long>{
	
	Tratamiento findById(long id);
	//Tratamiento findByCultivo(Cultivo cultivo);
	Tratamiento findByFechaTratamiento(LocalDate fecha);
	Tratamiento findByFechaReentrada (LocalDate fecha);
	Tratamiento findByFechaRecoleccion (LocalDate fecha);
}
