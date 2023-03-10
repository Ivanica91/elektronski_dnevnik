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
public class Razred {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name= "Razred")
	private RazredEnum razredEnum;
	
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name= "Razred_u_kome_se_drzi_predmet")
	private Predmet razredPredmet ;
	
	@OneToMany(mappedBy = "id", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<Odeljenje> razredSaOdeljenjima = new ArrayList<Odeljenje>();
	
	
	public Razred() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public RazredEnum getRazredEnum() {
		return razredEnum;
	}
	public void setRazredEnum(RazredEnum razredEnum) {
		this.razredEnum = razredEnum;
	}

	public Razred(Integer id, RazredEnum razredEnum) {
		super();
		this.id = id;
		this.razredEnum = razredEnum;
	}

	public Predmet getRazredPredmet() {
		return razredPredmet;
	}

	public void setRazredPredmet(Predmet razredPredmet) {
		this.razredPredmet = razredPredmet;
	}

	public Razred(Integer id, RazredEnum razredEnum, Predmet razredPredmet) {
		super();
		this.id = id;
		this.razredEnum = razredEnum;
		this.razredPredmet = razredPredmet;
	}

	public List<Odeljenje> getRazredSaOdeljenjima() {
		return razredSaOdeljenjima;
	}

	public void setRazredSaOdeljenjima(List<Odeljenje> razredSaOdeljenjima) {
		this.razredSaOdeljenjima = razredSaOdeljenjima;
	}

	public Razred(Integer id, RazredEnum razredEnum, Predmet razredPredmet, List<Odeljenje> razredSaOdeljenjima) {
		super();
		this.id = id;
		this.razredEnum = razredEnum;
		this.razredPredmet = razredPredmet;
		this.razredSaOdeljenjima = razredSaOdeljenjima;
	}


}	