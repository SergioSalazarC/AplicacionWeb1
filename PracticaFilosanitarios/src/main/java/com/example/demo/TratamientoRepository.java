package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TratamientoRepository  extends JpaRepository<Tratamiento, Long>{
	Tratamiento findByNumeroLoteFabricacion(String numeroLoteFabricacion);
	Tratamiento findById(long id);
	List<Tratamiento> findByCultivo(Cultivo cultivo);
	List<Tratamiento> findByFechaTratamiento(LocalDate fecha);
	List<Tratamiento> findByFechaReentrada (LocalDate fecha);
	List<Tratamiento> findByFechaRecoleccion (LocalDate fecha);
	List<Tratamiento> findByFechaReentradaAfterOrderByCultivo (LocalDate fecha);
	List<Tratamiento> findByFechaRecoleccionAfterOrderByCultivo (LocalDate fecha);
	List<Tratamiento> findByFechaReentradaAfterOrderByFechaReentrada (LocalDate fecha);
	List<Tratamiento> findByFechaRecoleccionAfterOrderByFechaReentrada (LocalDate fecha);
	List<Tratamiento> findByFechaReentradaAfterOrderByFechaRecoleccion (LocalDate fecha);
	List<Tratamiento> findByFechaRecoleccionAfterOrderByFechaRecoleccion (LocalDate fecha);
}
