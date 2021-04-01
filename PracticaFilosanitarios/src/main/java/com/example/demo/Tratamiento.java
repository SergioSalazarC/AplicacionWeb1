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
	
	private String numeroLoteFrabricacion;
	private LocalDate fechaTratamiento;
	private LocalDate fechaTermina;
	
	
}
