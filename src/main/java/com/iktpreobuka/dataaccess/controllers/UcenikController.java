package com.iktpreobuka.dataaccess.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dataaccess.entities.Ucenik;
import com.iktpreobuka.dataaccess.entities.UlogaKorisnik;
import com.iktpreobuka.dataaccess.entities.UserEntity;
import com.iktpreobuka.dataaccess.repositories.UcenikRepository;
import com.iktpreobuka.dataaccess.services.UcenikService;

@RestController
@RequestMapping("/ucenik")
public class UcenikController {
	@Autowired
	public UcenikRepository ucenikRepository;
	@Autowired
	private UcenikService ucenikService;


	
	@RequestMapping(method = RequestMethod.POST)
	public Ucenik addUcenik(@RequestBody Ucenik noviUcenik) {
		Ucenik ucenik = new Ucenik();
		ucenik.setIme(noviUcenik.getIme());
		ucenik.setPrezime(noviUcenik.getPrezime());
		ucenik.setKorisnickoIme(noviUcenik.getKorisnickoIme());
		ucenik.setLozinka(noviUcenik.getLozinka());
		ucenik.setUlogaKorisnik(UlogaKorisnik.Korisnik_UCENIK);
		 ucenikRepository.save(ucenik);
		 return ucenik;
	}
	
	
	@RequestMapping(method = RequestMethod.GET,value="/lista ucenika")
	public Iterable<Ucenik> getUcenik(){
		return ucenikRepository.findAll();
	}
	
	@RequestMapping (method = RequestMethod.GET, value="/get/{id}")
	public Ucenik getUcenikById(@PathVariable int id) {
		return ucenikRepository.findById(id).get();
	}

	
	
	@RequestMapping(method = RequestMethod.PUT, value="/update/{id}")
	public UserEntity updateUcenik(@RequestBody Ucenik noviUcenik, @PathVariable int id) {
		Ucenik ucenik = new Ucenik();
		ucenik.setId(id);
		ucenik.setIme(noviUcenik.getIme());
		ucenik.setPrezime(noviUcenik.getPrezime());
		ucenik.setKorisnickoIme(noviUcenik.getKorisnickoIme());
		ucenik.setLozinka(noviUcenik.getLozinka());
		ucenik.setUlogaKorisnik(UlogaKorisnik.Korisnik_UCENIK);
		 ucenikRepository.save(ucenik);
		 return ucenik;
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/delete/{id}")
	public String delete(@PathVariable int id){
			ucenikRepository.deleteById(id);
			return "Ucenik sa id brojem " + id  + " je izbrisan.";
	}	
	
	@RequestMapping (method = RequestMethod.PUT, value= "/dodavanjeOdeljenja")
	public Ucenik dodajUOdeljenje ( @PathVariable int ucenikId, @PathVariable int odeljenjeId) {
		return ucenikService.dodajOdeljenjeUceniku(ucenikId, odeljenjeId);
		
	}
	
	@RequestMapping (method =  RequestMethod.PUT, value = "/dodajPredmetUceniku/{ucenikiId}/{predmetId}")
	public Ucenik  dodajPredmetUceniku (@PathVariable int ucenikId, @PathVariable int predmetId) {
		return ucenikService.dodajPredmetUceniku(ucenikId, predmetId );
	}
	
	@RequestMapping (method =  RequestMethod.PUT, value = "/dodajRoditeljaUceniku/{ucenikiId}/{roditeljId}")
	public Ucenik  dodajRoditeljaUceniku (@PathVariable int ucenikId, @PathVariable int roditeljId) {
		return ucenikService.dodajRoditeljaUceniku(ucenikId, roditeljId );
	}
}
	
	
	
	
	
	

