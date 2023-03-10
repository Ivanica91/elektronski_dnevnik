
package com.iktpreobuka.dataaccess.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Predmet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name= "Naziv_predmeta")
	private String naziv; //naziv predmeta
	@Column(name= "Nedeljni_fond_casova_za_predmet")
	private Integer nedeljniFond; //nedeljni fond casova
	@Column(name= "Razred")
	protected RazredEnum Razred;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "predmet_koji_drzi", joinColumns =
	{ @JoinColumn(name = "Predmet_id", nullable = false, updatable = false) },
	inverseJoinColumns = { @JoinColumn(name = "Nastavnik_id", nullable = false,
	updatable = false) })
	protected Set<Nastavnik> nastavnici = new HashSet<Nastavnik>();
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "Predmet_koji_pohadja_ucenik", joinColumns =
	{ @JoinColumn(name = "Predmet_id", nullable = false, updatable = false) },
	inverseJoinColumns = { @JoinColumn(name = "Ucenik_id", nullable = false,
	updatable = false) })
	protected Set<Ucenik> predmetKojiPohadjaUcenik = new HashSet<Ucenik>();

//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
//	@JoinTable(name = "Ocenjivanje", joinColumns =
//	{ @JoinColumn(name = "Predmet_id", nullable = false, updatable = false) },
//	inverseJoinColumns = { @JoinColumn(name = "Ocena_id", nullable = false,
//	updatable = false) })
//	protected Set<Ocena> ocene = new HashSet<Ocena>();
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn (name= "ocenjivanje")
	private Ocena ocena ;

	@OneToMany(mappedBy = "id", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<ZakljucnaOcena> predmetZakljucnaOcena = new ArrayList<ZakljucnaOcena>();
	
	@OneToMany(mappedBy = "id", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<Razred> predmetURazredu = new ArrayList<Razred>();
	
	public Predmet() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public Set<Nastavnik> getNastavnici() {
		return nastavnici;
	}




	public void setNastavnici(Set<Nastavnik> nastavnici) {
		this.nastavnici = nastavnici;
	}




	



	public Predmet(Integer id, String naziv, Integer nedeljniFond, RazredEnum razred, Set<Nastavnik> nastavnici) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.nedeljniFond = nedeljniFond;
		Razred = razred;
		this.nastavnici = nastavnici;
	}




	public Set<Ucenik> getPredmetKojiPohadjaUcenik() {
		return predmetKojiPohadjaUcenik;
	}




	public void setPredmetKojiPohadjaUcenik(Set<Ucenik> predmetKojiPohadjaUcenik) {
		this.predmetKojiPohadjaUcenik = predmetKojiPohadjaUcenik;
	}




	public Predmet(Integer id, String naziv, Integer nedeljniFond, RazredEnum razred, Set<Nastavnik> nastavnici,
			Set<Ucenik> predmetKojiPohadjaUcenik) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.nedeljniFond = nedeljniFond;
		Razred = razred;
		this.nastavnici = nastavnici;
		this.predmetKojiPohadjaUcenik = predmetKojiPohadjaUcenik;
	}


	public Ocena getOcena() {
		return ocena;
	}




	public void setOcena(Ocena ocena) {
		this.ocena = ocena;
	}




	public Predmet(Integer id, String naziv, Integer nedeljniFond, RazredEnum razred, Set<Nastavnik> nastavnici,
			Set<Ucenik> predmetKojiPohadjaUcenik, Ocena ocena) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.nedeljniFond = nedeljniFond;
		Razred = razred;
		this.nastavnici = nastavnici;
		this.predmetKojiPohadjaUcenik = predmetKojiPohadjaUcenik;
		this.ocena = ocena;
	}


	public List<ZakljucnaOcena> getPredmetZakljucnaOcena() {
		return predmetZakljucnaOcena;
	}




	public void setPredmetZakljucnaOcena(List<ZakljucnaOcena> predmetZakljucnaOcena) {
		this.predmetZakljucnaOcena = predmetZakljucnaOcena;
	}




	public Predmet(Integer id, String naziv, Integer nedeljniFond, RazredEnum razred, Set<Nastavnik> nastavnici,
			Set<Ucenik> predmetKojiPohadjaUcenik, Ocena ocena, List<ZakljucnaOcena> predmetZakljucnaOcena) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.nedeljniFond = nedeljniFond;
		Razred = razred;
		this.nastavnici = nastavnici;
		this.predmetKojiPohadjaUcenik = predmetKojiPohadjaUcenik;
		this.ocena = ocena;
		this.predmetZakljucnaOcena = predmetZakljucnaOcena;
	}



	public List<Razred> getPredmetURazredu() {
		return predmetURazredu;
	}




	public void setPredmetURazredu(List<Razred> predmetURazredu) {
		this.predmetURazredu = predmetURazredu;
	}




	public Predmet(Integer id, String naziv, Integer nedeljniFond, RazredEnum razred, Set<Nastavnik> nastavnici,
			Set<Ucenik> predmetKojiPohadjaUcenik, Ocena ocena, List<ZakljucnaOcena> predmetZakljucnaOcena,
			List<com.iktpreobuka.dataaccess.entities.Razred> predmetURazredu) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.nedeljniFond = nedeljniFond;
		Razred = razred;
		this.nastavnici = nastavnici;
		this.predmetKojiPohadjaUcenik = predmetKojiPohadjaUcenik;
		this.ocena = ocena;
		this.predmetZakljucnaOcena = predmetZakljucnaOcena;
		this.predmetURazredu = predmetURazredu;
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



	public Integer getNedeljniFond() {
		return nedeljniFond;
	}



	public void setNedeljniFond(Integer nedeljniFond) {
		this.nedeljniFond = nedeljniFond;
	}



	public RazredEnum getRazred() {
		return Razred;
	}



	public void setRazred(RazredEnum razred) {
		Razred = razred;
	}



	public Predmet(Integer id, String naziv, Integer nedeljniFond, com.iktpreobuka.dataaccess.entities.RazredEnum razred) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.nedeljniFond = nedeljniFond;
		Razred = razred;
	}
	
	
}

