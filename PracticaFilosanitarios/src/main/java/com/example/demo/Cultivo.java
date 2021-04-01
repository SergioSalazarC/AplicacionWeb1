package com.example.demo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate
import java.util.*;

@Entity
public class Cultivo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String especie;
	private String variedad;
	private LocalDate plantado;
	private String zona;
	@OneToMany
	@JoinTable(name="Tratamiento",
	joinColumns=@JoinColumn(name="CULT_ID"),
	inverseJoinColumns=@JoinColumn(name="PROD_ID"))
	private Arraylist<Tratamiento> tratamientos; 
	public Cultivo() {		
	}
	public Cultivo(String e, String v, LocalDate p,String z) {
		this.especie=e;
		this.variedad=v;
		this.plantado=p;
		this.zona=z;
		this.tratamientos = new ArrayList<Tratamiento>();
				
	}
	public Cultivo(String e, String v, LocalDate p) {
		this.especie=e;
		this.variedad=v;
		this.plantado=p;
		this.zona="";
		this.tratamientos = new ArrayList();
	}
	public long getId() {
		return this.id;
	}
	public void setId(long idd) {
		this.id = idd;
	}
	public String getEspecie() {
		return this.especie
	}
	public void setEspecie(String esp) {
		this.especie=esp;
	}
	public String getVariedad() {
		return this.variedad;
	}
	public void setVariedad(String var) {
		this.variedad=var;
	}
	public String getZona() {
		return this.zona;
	}
	public void setZona(String zon) {
		this.zona = zon;
	}
	public ArrayList<Tratamiento> getTratamientos() {
		return this.tratamientos;
	}
	public void setTratamientos(ArrayList<Tratamiento> trat) {
		this.tratamientos = trat;
	}
}
