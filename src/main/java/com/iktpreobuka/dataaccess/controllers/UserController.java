package com.iktpreobuka.dataaccess.controllers;



import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;


import com.iktpreobuka.dataaccess.entities.UserEntity;
import com.iktpreobuka.dataaccess.repositories.UserRepository;


@RestController
@RequestMapping("/api/v1/elektronski_dnevnik/korisnik")
public class UserController { 
	
	@Autowired
	public UserRepository userRepository;
	
	@RequestMapping("/greetings")
	public String dobrodoslica() {
		return "Dobro dosli u elektronski dnevnik za osnovnu skolu";
	}

	@RequestMapping (method = RequestMethod.GET, value="/lista korisnika")
	public Iterable<UserEntity> getUserEntity(){
		return userRepository.findAll();
	}
	
//	@RequestMapping(method = RequestMethod.POST)
//	public UserEntity addUcenik(@RequestBody UserEntity noviKorisnik) {
//		UserEntity korisnik = new UserEntity();
//		korisnik.setIme(noviKorisnik.getIme());
//		korisnik.setPrezime(noviKorisnik.getPrezime());
//		korisnik.setKorisnickoIme(noviKorisnik.getKorisnickoIme());
//		korisnik.setLozinka(noviKorisnik.getLozinka());
//		korisnik.setUlogaKorisnik(UlogaKorisnik.Korisnik_UCENIK);
//		 userRepository.save(korisnik);
//		 return korisnik;
		 
//	}
	
	
//	@RequestMapping(method = RequestMethod.GET)
//	public List<UserEntity> getAllUsers1() {
	//@RequestMapping(method = RequestMethod.GET)
		//List<UserEntity> getAllUsers(){
//			return (List<UserEntity>) userRepository.findAll();
//	}
	

	
}
