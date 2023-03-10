package com.iktpreobuka.dataaccess.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dataaccess.entities.Roditelj;
import com.iktpreobuka.dataaccess.entities.UlogaKorisnik;
import com.iktpreobuka.dataaccess.repositories.RoditeljRepository;

@RestController
@RequestMapping("/roditelj")
public class RoditeljController {
	@Autowired
	public RoditeljRepository roditeljRepository;
	
	
		
	@RequestMapping(method = RequestMethod.POST)
	public Roditelj addRoditelj (@RequestBody Roditelj noviRoditelj) {
		Roditelj roditelj = new Roditelj();
		roditelj.setIme (noviRoditelj.getIme());
		roditelj.setPrezime (noviRoditelj.getPrezime());
		roditelj.setKorisnickoIme (noviRoditelj.getKorisnickoIme());
		roditelj.setLozinka(noviRoditelj.getLozinka());
		roditelj.setEmail(noviRoditelj.getEmail());
		roditelj.setUlogaKorisnik(UlogaKorisnik.Korisnik_RODITELj);
		roditeljRepository.save(roditelj);
		return roditelj;
			
	}
	
	@RequestMapping(method = RequestMethod.GET, value= "/lista roditelja")
	public Iterable<Roditelj> getRoditelj(){
		return roditeljRepository.findAll();
	}
	
	@RequestMapping (method=RequestMethod.GET, value = "/get/{id}" )
	public Roditelj getRoditeljById(@PathVariable int id) {
		return roditeljRepository.findById(id).get();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/update/{id}")
	public Roditelj updateRoditelj (@RequestBody Roditelj noviRoditelj, @PathVariable int id) {
		Roditelj roditelj = new Roditelj();
		roditelj.setId(id);
		roditelj.setIme (noviRoditelj.getIme());
		roditelj.setPrezime (noviRoditelj.getPrezime());
		roditelj.setKorisnickoIme (noviRoditelj.getKorisnickoIme());
		roditelj.setLozinka(noviRoditelj.getLozinka());
		roditelj.setEmail(noviRoditelj.getEmail());
		roditelj.setUlogaKorisnik(UlogaKorisnik.Korisnik_RODITELj);
		roditeljRepository.save(roditelj);
		return roditelj;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/delete/{id}")
	public String delete(@PathVariable int id){
		roditeljRepository.deleteById(id);
		return "Roditelj sa id brojem " + id  + " je izbrisan." ;
	}
	
}
