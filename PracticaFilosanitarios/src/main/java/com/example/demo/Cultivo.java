package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.Date;

@Entity
public class Cultivo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String especie;
	private String variedad;
	private Date plantado;
	private String zona;
	/*@OneToMany(mappedBy="cultivo")
	private ArrayList<Tratamiento> tratamientos; */
	public Cultivo() {		
	}
	public Cultivo(String e, String v, Date p,String z) {
		this.especie=e;
		this.variedad=v;
		this.plantado=p;
		this.zona=z;
		/*this.tratamientos = new ArrayList<Tratamiento>();*/
				
	}
	public Cultivo(String e, String v, Date p) {
		this.especie=e;
		this.variedad=v;
		this.plantado=p;
		this.zona="";
		/*this.tratamientos = new ArrayList<Tratamiento>();*/
	}
	/*public Cultivo(String e, String v, Date p,ArrayList<Tratamiento> trat,String z) {
		this.especie=e;
		this.variedad=v;
		this.plantado=p;
		this.zona=z;
		this.tratamientos = trat;
	}*/
	/*public Cultivo(String e, String v, Date p,rrayList<Tratamiento> trat) {
		this.especie=e;
		this.variedad=v;
		this.plantado=p;
		this.zona="";
		this.tratamientos = trat;
	}*/
	
	public long getId() {
		return this.id;
	}
	public void setId(long idd) {
		this.id = idd;
	}
	public String getEspecie() {
		return this.especie;
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
	public Date getPlantado() {
		return this.plantado;
	}
	public void setPlantado(Date plat) {
		this.plantado = plat;
	}
	/*public ArrayList<Tratamiento> getTratamientos() {
		return this.tratamientos;
	}
	public void setTratamientos(ArrayList<Tratamiento> trat) {
		this.tratamientos = trat;
	}
	public void añadirtratamiento(Tratamiento trat) {
		this.tratamientos.add(trat);
	}*/
}
