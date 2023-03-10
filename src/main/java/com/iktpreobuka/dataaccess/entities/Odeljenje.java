package com.iktpreobuka.dataaccess.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Odeljenje extends Razred {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name= "Naziv_odeljenja")
	private String naziv; //naziv odeljenja
//	@Column (name= "Razred")
//	private RazredEnum razred;
	
	
	@OneToMany(mappedBy = "id", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<Ucenik> ucenici = new ArrayList<Ucenik>();
	
	@OneToMany(mappedBy = "id", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<Nastavnik> nastavnikPredajeOdeljenju = new ArrayList<Nastavnik>();
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name= "Odeljnje_koje_pripada_razredu")
	private Razred odeljenjeRazred ;
	
	public Odeljenje() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Odeljenje(Integer id, RazredEnum razredEnum, Predmet razredPredmet) {
		super(id, razredEnum, razredPredmet);
		// TODO Auto-generated constructor stub
	}


	public Odeljenje(Integer id, RazredEnum razredEnum) {
		super(id, razredEnum);
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}




	public Odeljenje(Integer id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}


	public List<Ucenik> getUcenici() {
		return ucenici;
	}


	public void setUcenici(List<Ucenik> ucenici) {
		this.ucenici = ucenici;
	}


	public Odeljenje(Integer id, String naziv,  List<Ucenik> ucenici) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.ucenici = ucenici;
	}


	public List<Nastavnik> getNastavnikPredajeOdeljenju() {
		return nastavnikPredajeOdeljenju;
	}


	public void setNastavnikPredajeOdeljenju(List<Nastavnik> nastavnikPredajeOdeljenju) {
		this.nastavnikPredajeOdeljenju = nastavnikPredajeOdeljenju;
	}




	public Odeljenje(Integer id, String naziv, List<Ucenik> ucenici, List<Nastavnik> nastavnikPredajeOdeljenju) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.ucenici = ucenici;
		this.nastavnikPredajeOdeljenju = nastavnikPredajeOdeljenju;
	}


	public Razred getOdeljenjeRazred() {
		return odeljenjeRazred;
	}


	public void setOdeljenjeRazred(Razred odeljenjeRazred) {
		this.odeljenjeRazred = odeljenjeRazred;
	}


	public Odeljenje(Integer id, String naziv, List<Ucenik> ucenici, List<Nastavnik> nastavnikPredajeOdeljenju,
			Razred odeljenjeRazred) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.ucenici = ucenici;
		this.nastavnikPredajeOdeljenju = nastavnikPredajeOdeljenju;
		this.odeljenjeRazred = odeljenjeRazred;
	}
	

}