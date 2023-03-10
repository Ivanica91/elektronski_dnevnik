package com.iktpreobuka.dataaccess.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dataaccess.entities.Odeljenje;
import com.iktpreobuka.dataaccess.repositories.OdeljenjeRepository;

@RestController
@RequestMapping("/odeljenje")
public class OdeljenjeController {
	@Autowired
	public OdeljenjeRepository odeljenjeRepository;
	
	private final Logger logger = LoggerFactory.getLogger(OdeljenjeController.class);

	@RequestMapping(method = RequestMethod.POST)
	public Odeljenje addOdeljenje (@RequestBody Odeljenje odeljenje) {
		logger.info("Pokrenuta je metoda Odeljenje");
		Odeljenje novoOdeljenje = new Odeljenje();
		novoOdeljenje.setNaziv (odeljenje.getNaziv());
		novoOdeljenje.setRazredEnum(odeljenje.getRazredEnum());
		odeljenjeRepository.save(novoOdeljenje);
		return novoOdeljenje;
	}
	
	@RequestMapping(method= RequestMethod.GET, value ="/lista odeljenja")
	public Iterable<Odeljenje> getOdeljenje(){
		return odeljenjeRepository.findAll();
	}
	
	
	@RequestMapping(method= RequestMethod.GET, value ="/get/{id}")
	public Odeljenje getOdelkjenjeById(@PathVariable int id){
		return odeljenjeRepository.findById(id).get();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
	public Odeljenje updateOdeljenje (@RequestBody Odeljenje novoOdeljenje, @PathVariable int id) {
		Odeljenje odeljenje = new Odeljenje();
		odeljenje.setId(id);
		odeljenje.setNaziv (novoOdeljenje.getNaziv());
		odeljenje.setRazredEnum(novoOdeljenje.getRazredEnum());
		odeljenjeRepository.save(odeljenje);
		return odeljenje;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/delete/{id}")
	public String delete(@PathVariable int id){
			odeljenjeRepository.deleteById(id);
			return "Odeljenje sa id brojem " + id  + " je izbrisan.";
	}
	
	
}
