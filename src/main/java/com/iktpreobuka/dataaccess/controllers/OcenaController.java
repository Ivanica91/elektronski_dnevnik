package com.iktpreobuka.dataaccess.controllers;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.iktpreobuka.dataaccess.entities.Ocena;
import com.iktpreobuka.dataaccess.repositories.OcenaRepository;
import com.iktpreobuka.dataaccess.services.OcenaService;
@RestController
@RequestMapping("/Ocena")
public class OcenaController {

		@Autowired
		public OcenaRepository ocenaRepository;
		@Autowired
		private OcenaService ocenaService;
		
		private final Logger logger = LoggerFactory.getLogger(OcenaController.class);
	
		@RequestMapping(method = RequestMethod.POST)
		public Ocena addOcena (@RequestBody Ocena ocena) {
			logger.info("Pokrenuta je metoda Ocena");
			Ocena novaOcena = new Ocena();
			novaOcena.setOcena (ocena.getOcena());
			novaOcena.setNazivOcene(ocena.getNazivOcene());
			novaOcena.setDate(LocalDate.now());
			novaOcena.setPolugodiste(ocena.getPolugodiste());
			ocenaRepository.save(novaOcena);
			return novaOcena;
		}
		

		@RequestMapping(method = RequestMethod.GET, value= "/lista ocena")
		public Iterable<Ocena> getOcena(){
			return ocenaRepository.findAll();
		}
		
		@RequestMapping (method=RequestMethod.GET, value = "/get/{id}" )
		public Ocena getOcenaById(@PathVariable long id) {
			return ocenaRepository.findById((long) id).get();
		}
		
		@RequestMapping(method = RequestMethod.PUT,value="/update/{id}" )
		public Ocena updateOcena (@RequestBody Ocena ocena, @PathVariable long id) {
			Ocena novaOcena = new Ocena();
			novaOcena.setId(id);
			novaOcena.setOcena (ocena.getOcena());
			novaOcena.setNazivOcene(ocena.getNazivOcene());
			novaOcena.setDate(LocalDate.now());
			novaOcena.setPolugodiste(ocena.getPolugodiste());
			ocenaRepository.save(novaOcena);
			return novaOcena;
		}
		@RequestMapping(method = RequestMethod.DELETE, value="/delete/{id}")
		public String delete(@PathVariable long id){
			ocenaRepository.deleteById(id);
			return "Ocena sa id brojem " + id  + " je izbrisan." ;
		}

//		@RequestMapping (method =  RequestMethod.PUT, value = "/ocenjivanjeUcenika/{ocenaId}/{ucenikId}")
//		public Ocena  dodajOcenuUceniku (@PathVariable long ocenaId, @PathVariable int ucenikId) {
//			return ocenaService.dodajOcenuUceniku(ocenaId, ucenikId );
//		}
		
		@RequestMapping (method =  RequestMethod.PUT, value = "/ocenaZaZakljucivanje/{ocenaId}/{zakljucnaOcenaId}")
		public Ocena  dodajOcenuZaZakljucivanje (@PathVariable long ocenaId, @PathVariable long zakljucnaOcenaId) {
			return ocenaService.dodajOcenuZaZakljucivanje(ocenaId, zakljucnaOcenaId );
		}
}
