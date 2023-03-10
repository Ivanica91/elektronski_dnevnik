package com.iktpreobuka.dataaccess.entities;

import javax.persistence.Entity;

@Entity
public class Admin extends UserEntity {

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Integer id, String ime, String prezime, String korisnickoIme, String lozinka,
			UlogaKorisnik ulogaKorisnik) {
		super(id, ime, prezime, korisnickoIme, lozinka, ulogaKorisnik);
		// TODO Auto-generated constructor stub
	}
	
	
}
	
	
	
