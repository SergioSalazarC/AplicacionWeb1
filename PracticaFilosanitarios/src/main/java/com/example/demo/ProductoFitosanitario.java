package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductoFitosanitario {
	//Clave Primaria para los productos Fitosanitarios
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String descripcion;
	private long plazoDeReentrada;
	private long plazoDeRecoleccion;
	
	public ProductoFitosanitario() {
		
	}
	
	public ProductoFitosanitario(String nom, String des, long plazoRen, long plazoRec) {
		this.nombre=nom;
		this.descripcion=des;
		this.plazoDeReentrada=plazoRen;
		this.plazoDeRecoleccion=plazoRec;
	}
	
	public ProductoFitosanitario(String nom, long plazoRen, long plazoRec) {
		this.nombre=nom;
		this.descripcion="";
		this.plazoDeReentrada=plazoRen;
		this.plazoDeRecoleccion=plazoRec;
	}
	
	public long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public long getPlazoDeReentrada() {
		return plazoDeReentrada;
	}

	public void setPlazoDeReentrada(long plazoDeReentrada) {
		this.plazoDeReentrada = plazoDeReentrada;
	}

	public long getPlazoDeRecoleccion() {
		return plazoDeRecoleccion;
	}

	public void setPlazoDeRecoleccion(long plazoDeRecoleccion) {
		this.plazoDeRecoleccion = plazoDeRecoleccion;
	}
	
	

}
