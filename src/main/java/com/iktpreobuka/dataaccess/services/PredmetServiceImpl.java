package com.iktpreobuka.dataaccess.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.iktpreobuka.dataaccess.entities.Ocena;
import com.iktpreobuka.dataaccess.entities.Predmet;
import com.iktpreobuka.dataaccess.repositories.PredmetRepository;
@Service
public class PredmetServiceImpl implements PredmetService {

	@Autowired
	private PredmetRepository predmetRepository;
	@Autowired
	private OcenaService ocenaService;

	
	@Override
	public Predmet findById(int id) {
		return predmetRepository.findById(id).get();
	}
	//dodajOcenuPredmetu
	
	@Override
	public Predmet dodajOcenuPredmetu (int predmetId, long ocenaId) {
		Predmet predmet = predmetRepository.findById(predmetId).get();
		Ocena ocena = ocenaService.findById(ocenaId);
		predmet.setOcena(ocena);
		return predmetRepository.save(predmet);
		
	}
	
}
