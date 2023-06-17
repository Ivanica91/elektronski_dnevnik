package com.iktpreobuka.dataaccess.controllers;






import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dataaccess.entities.Nastavnik;
import com.iktpreobuka.dataaccess.entities.UlogaKorisnik;
import com.iktpreobuka.dataaccess.repositories.NastavnikRepository;
import com.iktpreobuka.dataaccess.services.NastavnikService;

@RestController
@RequestMapping("/nastavnik")
@CrossOrigin(origins = "http://localhost:3000")
public class NastavnikController {
	
	@Autowired
	public NastavnikRepository nastavnikRepository;
	@Autowired
	private NastavnikService nastavnikService;
	
	private final Logger logger = LoggerFactory.getLogger(NastavnikController.class);

	
	@RequestMapping(method = RequestMethod.POST)
	public Nastavnik addNastavnik (@RequestBody Nastavnik noviNastavnik ) {
		logger.info("Pokrenuta je metoda Nastavnik");
		Nastavnik nastavnik = new Nastavnik();
		nastavnik.setIme (noviNastavnik.getIme());
		nastavnik.setPrezime (noviNastavnik.getPrezime());
		nastavnik.setKorisnickoIme (noviNastavnik.getKorisnickoIme());
		nastavnik.setLozinka(noviNastavnik.getLozinka());
		nastavnik.setUlogaKorisnik(UlogaKorisnik.Korisnik_NASTAVNIK);
		nastavnikRepository.save(nastavnik);
		return nastavnik;
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/listanastavnika")
	public Iterable<Nastavnik> getNastavnik(){
		return nastavnikRepository.findAll();
		
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/update/{id}")
	public Nastavnik getNastavnikById(@PathVariable int id){
		return nastavnikRepository.findById(id).get();
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/update/{id}")
	public Nastavnik updateNastavnik (@RequestBody Nastavnik noviNastavnik,@PathVariable int id ) {
		Nastavnik nastavnik = new Nastavnik();
		nastavnik.setId(id);
		nastavnik.setIme (noviNastavnik.getIme());
		nastavnik.setPrezime (noviNastavnik.getPrezime());
		nastavnik.setKorisnickoIme (noviNastavnik.getKorisnickoIme());
		nastavnik.setLozinka(noviNastavnik.getLozinka());
		nastavnik.setUlogaKorisnik(UlogaKorisnik.Korisnik_NASTAVNIK);
		nastavnikRepository.save(nastavnik);
		return nastavnik;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/delete/{id}")
	public String delete(@PathVariable int id){
			nastavnikRepository.deleteById(id);
			return "Nastavnik sa id brojem " + id  + " je izbrisan.";
	}
	
	@RequestMapping (method =  RequestMethod.PUT, value = "/dodajPredmetNastavniku/{nastavnikId}/{predmetId}")
	public Nastavnik  dodajPredmetNastavniku (@PathVariable int nastavnikId, @PathVariable int predmetId) {
		return nastavnikService.dodajPredmetNastavniku(nastavnikId, predmetId );
	}
	
	
	@RequestMapping (method =  RequestMethod.PUT, value = "/dodajOdeljenjeNastavniku/{nastavnikId}/{odeljenjeId}")
	public Nastavnik  dodajOdeljenjeNastavniku (@PathVariable int nastavnikId, @PathVariable int odeljenjeId) {
		return nastavnikService.dodajOdeljenjeNastavniku(nastavnikId, odeljenjeId );
	}
	

	
}
	
