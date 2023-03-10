package com.iktpreobuka.dataaccess.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.iktpreobuka.dataaccess.entities.Odeljenje;
import com.iktpreobuka.dataaccess.entities.Predmet;
import com.iktpreobuka.dataaccess.entities.Roditelj;
import com.iktpreobuka.dataaccess.entities.Ucenik;
import com.iktpreobuka.dataaccess.repositories.UcenikRepository;
@Service
public class UcenikServiceImpl implements UcenikService {

	@Autowired
	private UcenikRepository ucenikRepository;
	@Autowired
	private OdeljenjeService odeljenjeService;
	@Autowired
	private RoditeljService roditeljService;
	@Autowired
	private PredmetService predmetService;
	
	@Override
	public Ucenik dodajOdeljenjeUceniku(int ucenikId, int odeljenjeId) {
		Ucenik ucenik = ucenikRepository.findById(ucenikId).get();
		Odeljenje odeljenje= odeljenjeService.findById(odeljenjeId);
		ucenik.setOdeljenje(odeljenje);
		return ucenikRepository.save(ucenik);
	}
	@Override
	public Ucenik dodajRoditeljaUceniku(int ucenikId, int roditeljId) {
		Ucenik ucenik = ucenikRepository.findById(ucenikId).get();
		Roditelj roditelj = roditeljService.findById(roditeljId);
		ucenik.setRoditelj(roditelj);
		return ucenikRepository.save(ucenik);
	}
	@Override
	public Ucenik findById(int id) {
		return ucenikRepository.findById(id).get();
	}
	
	@Override
	public Ucenik dodajPredmetUceniku (int ucenikId, int predmetId) {
		Ucenik ucenik = ucenikRepository.findById(ucenikId).get();
		Predmet predmet = predmetService.findById(predmetId);
		ucenik.getPredmeti().add(predmet);
		return ucenikRepository.save(ucenik);
		
	}
}
