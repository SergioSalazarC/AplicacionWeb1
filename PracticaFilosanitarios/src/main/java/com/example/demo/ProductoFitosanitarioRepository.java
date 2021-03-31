package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoFitosanitarioRepository  extends JpaRepository<ProductoFitosanitario,Long>{
	
	ProductoFitosanitario findByNombre(String nombre);
	ProductoFitosanitario findById(long id);
	ProductoFitosanitario findByPlazoDeReentrada(long plazoDeReentrada);
	ProductoFitosanitario findByPlazoDeRecoleccion(long plazoDeRecoleccion);
}
