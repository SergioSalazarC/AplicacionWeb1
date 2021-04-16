package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Cultivo implements Comparable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String especie;
	private String variedad;
	private Date plantado;
	private String zona;
	@OneToMany(mappedBy="cultivo")
	private Collection<Tratamiento> tratamientos = new HashSet<Tratamiento>();
	
	public Cultivo() {		
	}
	
	public Cultivo(String e, String v, Date p,String z) {
		this.especie=e;
		this.variedad=v;
		this.plantado=p;
		this.zona=z;
		this.tratamientos.add(new Tratamiento());
		//this.tratamientos = new HashSet();
				
	}
	public Cultivo(String e, String v, Date p) {
		this.especie=e;
		this.variedad=v;
		this.plantado=p;
		this.zona="";
		this.tratamientos.add(new Tratamiento());
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
	public Collection<Tratamiento> getTratamientos() {
		return this.tratamientos;
	}
	public void setTratamientos(Collection<Tratamiento> trat) {
		this.tratamientos = trat;
	}
	public void addTratamiento(Tratamiento trat) {
		this.tratamientos.add(trat);
	}

	@Override
	public int compareTo(Object o) {
		Cultivo c = (Cultivo) o;
		return this.especie.compareTo(c.especie);
	}
	
}
