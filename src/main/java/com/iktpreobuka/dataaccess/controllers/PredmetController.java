package com.iktpreobuka.dataaccess.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.iktpreobuka.dataaccess.entities.Predmet;
import com.iktpreobuka.dataaccess.repositories.PredmetRepository;
import com.iktpreobuka.dataaccess.services.PredmetService;

@RestController
@RequestMapping("/predmet")
public class PredmetController {
	
	@Autowired
	public PredmetRepository predmetRepository;
	@Autowired
	public PredmetService predmetService;
	
	private final Logger logger = LoggerFactory.getLogger(PredmetController.class);
	
	@RequestMapping(method= RequestMethod.POST)
	public Predmet addPredmet(@RequestBody Predmet noviPredmet) {
		logger.info("Pokrenuta je metoda Predmet");
		Predmet predmet = new Predmet();
		predmet.setNaziv(noviPredmet.getNaziv());
		predmet.setNedeljniFond(noviPredmet.getNedeljniFond());
		predmet.setRazred(noviPredmet.getRazred());
		 predmetRepository.save(predmet);
		 return predmet;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/lista predmeta")
	public Iterable<Predmet> getPredmet(){
		return predmetRepository.findAll();
	}

	@RequestMapping (method = RequestMethod.GET, value="/get/{id}")
	public Predmet getPredmetById(@PathVariable int id) {
		return predmetRepository.findById(id).get();
	}

	
	
	@RequestMapping(method= RequestMethod.PUT, value="/update/{id}")
	public Predmet updatePredmet(@RequestBody Predmet noviPredmet, @PathVariable int id) {
		Predmet predmet = new Predmet();
		predmet.setId(id);
		predmet.setNaziv(noviPredmet.getNaziv());
		predmet.setNedeljniFond(noviPredmet.getNedeljniFond());
		predmet.setRazred(noviPredmet.getRazred());
		predmetRepository.save(predmet);
		return predmet;
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE,value="/delete/{id}")
	public String delete(@PathVariable int id){
			predmetRepository.deleteById(id);
			return "Predmet sa id brojem " + id  + " je izbrisan.";
	}	 
	@RequestMapping (method =  RequestMethod.PUT, value = "/dodajOcenuPredmetu/{predmetId}/{ocenatId}")
	public Predmet  dodajOcenuPredmetu (@PathVariable int predmetId, @PathVariable long ocenaId) {
		return predmetService.dodajOcenuPredmetu(predmetId,ocenaId);
	}
	
	
}

