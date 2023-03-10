package com.iktpreobuka.dataaccess.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Roditelj extends UserEntity {
	@Column(name= "Email")
	private String email;


	
	@OneToMany(mappedBy = "roditelj", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<Ucenik> deca = new ArrayList<Ucenik>();

	public Roditelj() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roditelj(Integer id, String ime, String prezime, String korisnickoIme, String lozinka,
			UlogaKorisnik ulogaKorisnik) {
		super(id, ime, prezime, korisnickoIme, lozinka, ulogaKorisnik);
		// TODO Auto-generated constructor stub
	}

	
	
	public List<Ucenik> getDeca() {
		return deca;
	}

	public void setDeca(List<Ucenik> deca) {
		this.deca = deca;
	}
	
	

	public Roditelj(String email, List<Ucenik> deca) {
		super();
		this.email = email;
		this.deca = deca;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Roditelj(String email) {
		super();
		this.email = email;
	}

	
	
	
}
