package com.iktpreobuka.dataaccess.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.dataaccess.entities.Nastavnik;
import com.iktpreobuka.dataaccess.entities.Odeljenje;
import com.iktpreobuka.dataaccess.entities.Predmet;
import com.iktpreobuka.dataaccess.repositories.NastavnikRepository;
@Service
public class NastavnikServiceImpl implements NastavnikService{

	@Autowired
	private NastavnikRepository nastavnikRepository;
	@Autowired
	private PredmetService predmetService;
	@Autowired
	private OdeljenjeService odeljenjeService;
	
	@Override
	public Nastavnik dodajPredmetNastavniku (int nastavnikId, int predmetId) {
		Nastavnik nastavnik = nastavnikRepository.findById(nastavnikId).get();
		Predmet predmet = predmetService.findById(predmetId);
		nastavnik.getPredmeti().add(predmet);
		return nastavnikRepository.save(nastavnik);
		
	}
	
	public Nastavnik dodajOdeljenjeNastavniku (int nastavnikId, int odeljenjeId) {
		Nastavnik nastavnik = nastavnikRepository.findById(nastavnikId).get();
		Odeljenje odeljenje = odeljenjeService.findById(odeljenjeId);
		nastavnik.setNastavnikPredajeOdeljenju(odeljenje);
		return nastavnikRepository.save(nastavnik);
		
	}

//	@Override
//	public Nastavnik findById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}


}
