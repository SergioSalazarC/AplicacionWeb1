package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
public interface CultivoRepository extends JpaRepository<Cultivo,Long> {
	Cultivo findById(long id);
	List<Cultivo> findByEspecie(String especie);
	List<Cultivo> findByVariedad(String variedad);
	List<Cultivo> findByPlantado(LocalDate fecha);
	
}
