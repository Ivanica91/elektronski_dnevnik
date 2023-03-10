package com.iktpreobuka.dataaccess.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class UserEntity {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="Ime", nullable = false)
	private String ime;
	@Column (name= "Prezime_korisnika", nullable = false)
	private String prezime;
	
	@Column(name= "Korisnicko_ime")
	private String korisnickoIme;  //korisnicko ime
	@Column (name= "Lozinka ")
	private String lozinka;
	@Column (name= "Uloga_korisnika")
	protected UlogaKorisnik ulogaKorisnik;
	
	
	
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public UlogaKorisnik getUlogaKorisnik() {
		return ulogaKorisnik;
	}
	public void setUlogaKorisnik(UlogaKorisnik ulogaKorisnik) {
		this.ulogaKorisnik = ulogaKorisnik;
	}
	
	public UserEntity(Integer id, String ime, String prezime, String korisnickoIme, String lozinka,
			UlogaKorisnik ulogaKorisnik) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.ulogaKorisnik = ulogaKorisnik;
	}
	
	

	
}
