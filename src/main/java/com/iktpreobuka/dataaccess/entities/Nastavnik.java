package com.iktpreobuka.dataaccess.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity

public class Nastavnik extends UserEntity {
	
	@Column (name= "Nedeljni_fond_casova")
	private Integer nedeljniFond; //nedeljni fond casova



	@ManyToMany(mappedBy = "nastavnici",fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
//	@JoinTable(name = "nastavnik_predmet", joinColumns =
//	{ @JoinColumn(name = "Nastavnik_id", nullable = false, updatable = false) },
//	inverseJoinColumns = { @JoinColumn(name = "predmet_id", nullable = false,
//	updatable = false) })
	protected Set<Predmet> predmeti = new HashSet<Predmet>();
	
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name= "nastavnik_predaje_uceniku")
	private Ucenik ucenik ;
	
	
	@ManyToMany(mappedBy= "nastavnikOcena" ,fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
//	@JoinTable(name = "nastavnik_ocena", joinColumns =
//	{ @JoinColumn(name = "Nastavnik_id", nullable = false, updatable = false) },
//	inverseJoinColumns = { @JoinColumn(name = "Ocena_id", nullable = false,
//	updatable = false) })
	protected Set<Ocena> ocene = new HashSet<Ocena>();
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name= "nastavnik_predaje_odeljenju")
	private Odeljenje nastavnikPredajeOdeljenju ;
	

	public Nastavnik() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Nastavnik(Integer id, String ime, String prezime, String korisnickoIme, String lozinka,
			UlogaKorisnik ulogaKorisnik) {
		super(id, ime, prezime, korisnickoIme, lozinka, ulogaKorisnik);
		// TODO Auto-generated constructor stub
	}

	public Integer getNedeljniFond() {
		return nedeljniFond;
	}

	public void setNedeljniFond(Integer nedeljniFond) {
		this.nedeljniFond = nedeljniFond;
	}

	public Set<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(Set<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public Nastavnik(Integer nedeljniFond, Set<Predmet> predmeti) {
		super();
		this.nedeljniFond = nedeljniFond;
		this.predmeti = predmeti;
	}

	public Ucenik getUcenik() {
		return ucenik;
	}

	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}

	public Nastavnik(Integer nedeljniFond, Set<Predmet> predmeti, Ucenik ucenik) {
		super();
		this.nedeljniFond = nedeljniFond;
		this.predmeti = predmeti;
		this.ucenik = ucenik;
	}

	public Set<Ocena> getOcene() {
		return ocene;
	}

	public void setOcene(Set<Ocena> ocene) {
		this.ocene = ocene;
	}

	public Nastavnik(Integer nedeljniFond, Set<Predmet> predmeti, Ucenik ucenik, Set<Ocena> ocene) {
		super();
		this.nedeljniFond = nedeljniFond;
		this.predmeti = predmeti;
		this.ucenik = ucenik;
		this.ocene = ocene;
	}

	public Odeljenje getNastavnikPredajeOdeljenju() {
		return nastavnikPredajeOdeljenju;
	}

	public void setNastavnikPredajeOdeljenju(Odeljenje nastavnikPredajeOdeljenju) {
		this.nastavnikPredajeOdeljenju = nastavnikPredajeOdeljenju;
	}

	public Nastavnik(Integer nedeljniFond, Set<Predmet> predmeti, Ucenik ucenik, Set<Ocena> ocene,
			Odeljenje nastavnikPredajeOdeljenju) {
		super();
		this.nedeljniFond = nedeljniFond;
		this.predmeti = predmeti;
		this.ucenik = ucenik;
		this.ocene = ocene;
		this.nastavnikPredajeOdeljenju = nastavnikPredajeOdeljenju;
	}

	
}
