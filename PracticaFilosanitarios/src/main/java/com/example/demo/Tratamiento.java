package com.example.demo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tratamiento {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	
	@ManyToOne
	@JoinColumn(name="CULT_ID")
	private Cultivo cultivo;
	
	
	@ManyToOne
	@JoinColumn(name="PROD_ID")
	private ProductoFitosanitario producto;
	
	private String numeroLoteFabricacion;
	private LocalDate fechaTratamiento;
	private LocalDate fechaReentrada;
	private LocalDate fechaRecoleccion;
	
	public Tratamiento() {}
	public Tratamiento (Cultivo cultivo,ProductoFitosanitario producto, String numeroLoteFabricacion, LocalDate fechaTratamiento) {
		this.cultivo = cultivo;
		this.producto = producto;
		this.numeroLoteFabricacion = numeroLoteFabricacion;
		this.fechaTratamiento = fechaTratamiento;
		this.fechaReentrada = this.fechaTratamiento.plusDays(this.producto.getPlazoDeReentrada());
		this.fechaRecoleccion = this.fechaTratamiento.plusDays(this.producto.getPlazoDeRecoleccion());
	}

	public long getId() {
		return id;
	}
	
	
	@Override
	public String toString() {
		return( "Tratamiento" + this.id);
	}
	
	public Cultivo getCultivo() {
		return cultivo;
	}

	public void setCultivo(Cultivo cultivo) {
		this.cultivo = cultivo;
	}
	
	public ProductoFitosanitario getProducto() {
		return producto;
	}

	public void setProducto(ProductoFitosanitario producto) {
		this.producto = producto;
		this.fechaReentrada = this.fechaTratamiento.plusDays(this.producto.getPlazoDeReentrada());
		this.fechaRecoleccion = this.fechaTratamiento.plusDays(this.producto.getPlazoDeRecoleccion());
	}

	public String getNumeroLoteFabricacion() {
		return numeroLoteFabricacion;
	}

	public void setNumeroLoteFabricacion(String numeroLoteFabricacion) {
		this.numeroLoteFabricacion = numeroLoteFabricacion;
	}

	public LocalDate getFechaTratamiento() {
		return fechaTratamiento;
	}

	public void setFechaTratamiento(LocalDate fechaTratamiento) {
		this.fechaTratamiento = fechaTratamiento;
		this.fechaReentrada = this.fechaTratamiento.plusDays(this.producto.getPlazoDeReentrada());
		this.fechaRecoleccion = this.fechaTratamiento.plusDays(this.producto.getPlazoDeRecoleccion());
	}

	public LocalDate getFechaReentrada() {
		return fechaReentrada;
	}

	public LocalDate getFechaRecoleccion() {
		return fechaRecoleccion;
	}	
	
}
