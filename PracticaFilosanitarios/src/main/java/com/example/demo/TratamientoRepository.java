package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TratamientoRepository  extends JpaRepository<Tratamiento, Long>{
	Tratamiento findByNumeroLoteFabricacion(String numeroLoteFabricacion);
	Tratamiento findById(long id);
	Tratamiento findByCultivo(Cultivo cultivo);
	List<Tratamiento> findByFechaTratamiento(LocalDate fecha);
	List<Tratamiento> findByFechaReentrada (LocalDate fecha);
	List<Tratamiento> findByFechaRecoleccion (LocalDate fecha);
}
