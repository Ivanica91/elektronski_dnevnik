package com.iktpreobuka.dataaccess.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Ucenik extends UserEntity {
	


	
	


	@ManyToMany
	@JoinTable(name = "ucenik_pohadja_predmet",  joinColumns = @JoinColumn(name = "ucenik_id"),
	inverseJoinColumns = @JoinColumn(name = "predmet_id"))
	private Set<Predmet> predmeti;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name= "roditelj")
	private Roditelj roditelj ;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name= "ucenik_u_odeljenju")
	private Odeljenje odeljenje ;
	
	@OneToMany(mappedBy = "id", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<Ocena> ocena = new ArrayList<Ocena>();
	

	@OneToMany(mappedBy = "id", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<Nastavnik> UceniSlusaNastavnika = new ArrayList<Nastavnik>();
	
	@OneToMany(mappedBy = "id", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<ZakljucnaOcena> ucenikZakljucnaOcena = new ArrayList<ZakljucnaOcena>();

	public Ucenik() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ucenik(Integer id, String ime, String prezime, String korisnickoIme, String lozinka,
			UlogaKorisnik ulogaKorisnik) {
		super(id, ime, prezime, korisnickoIme, lozinka, ulogaKorisnik);
		// TODO Auto-generated constructor stub
	}

	public Set<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(Set<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public Ucenik(Set<Predmet> predmeti) {
		super();
		this.predmeti = predmeti;
	}

	public Roditelj getRoditelj() {
		return roditelj;
	}

	public void setRoditelj(Roditelj roditelj) {
		this.roditelj = roditelj;
	}

	public Ucenik(Set<Predmet> predmeti, Roditelj roditelj) {
		super();
		this.predmeti = predmeti;
		this.roditelj = roditelj;
	}

	public Odeljenje getOdeljenje() {
		return odeljenje;
	}

	public void setOdeljenje(Odeljenje odeljenje) {
		this.odeljenje = odeljenje;
	}

	public Ucenik(Set<Predmet> predmeti, Roditelj roditelj, Odeljenje odeljenje) {
		super();
		this.predmeti = predmeti;
		this.roditelj = roditelj;
		this.odeljenje = odeljenje;
	}

	public List<Ocena> getOcena() {
		return ocena;
	}

	public void setOcena(List<Ocena> ocena) {
		this.ocena = ocena;
	}

	public Ucenik(Set<Predmet> predmeti, Roditelj roditelj, Odeljenje odeljenje, List<Ocena> ocena) {
		super();
		this.predmeti = predmeti;
		this.roditelj = roditelj;
		this.odeljenje = odeljenje;
		this.ocena = ocena;
	}

	public List<Nastavnik> getUceniSlusaNastavnika() {
		return UceniSlusaNastavnika;
	}

	public void setUceniSlusaNastavnika(List<Nastavnik> uceniSlusaNastavnika) {
		UceniSlusaNastavnika = uceniSlusaNastavnika;
	}

	public Ucenik(Set<Predmet> predmeti, Roditelj roditelj, Odeljenje odeljenje, List<Ocena> ocena,
			List<Nastavnik> uceniSlusaNastavnika) {
		super();
		this.predmeti = predmeti;
		this.roditelj = roditelj;
		this.odeljenje = odeljenje;
		this.ocena = ocena;
		UceniSlusaNastavnika = uceniSlusaNastavnika;
	}

	public List<ZakljucnaOcena> getUcenikZakljucnaOcena() {
		return ucenikZakljucnaOcena;
	}

	public void setUcenikZakljucnaOcena(List<ZakljucnaOcena> ucenikZakljucnaOcena) {
		this.ucenikZakljucnaOcena = ucenikZakljucnaOcena;
	}

	public Ucenik(Set<Predmet> predmeti, Roditelj roditelj, Odeljenje odeljenje, List<Ocena> ocena,
			List<Nastavnik> uceniSlusaNastavnika, List<ZakljucnaOcena> ucenikZakljucnaOcena) {
		super();
		this.predmeti = predmeti;
		this.roditelj = roditelj;
		this.odeljenje = odeljenje;
		this.ocena = ocena;
		UceniSlusaNastavnika = uceniSlusaNastavnika;
		this.ucenikZakljucnaOcena = ucenikZakljucnaOcena;
	}
	
	
}