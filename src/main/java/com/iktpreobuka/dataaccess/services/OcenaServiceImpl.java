package com.iktpreobuka.dataaccess.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.dataaccess.entities.Ocena;

import com.iktpreobuka.dataaccess.entities.Ucenik;
import com.iktpreobuka.dataaccess.entities.ZakljucnaOcena;
import com.iktpreobuka.dataaccess.repositories.OcenaRepository;

@Service
public class OcenaServiceImpl implements OcenaService {
	@Autowired
	private OcenaRepository ocenaRepository;
//	@Autowired
//	private UcenikService ucenikService;
	@Autowired
	private ZakljucnaOcenaService zakljucnaOcenaService;
	

	@Override
	public Ocena findById(long id) {
		// TODO Auto-generated method stub
		return ocenaRepository.findById(id).get();
	}
	
//	@Override
//	public Ocena dodajOcenuUceniku (long ocenaId, int ucenikId) {
//		Ocena ocena = ocenaRepository.findById(ocenaId).get();
//		Ucenik ucenik = ucenikService.findById(ucenikId);
//		ocena.setOcenjivanjeUcenika(ucenik);
//		return ocenaRepository.save(ocena);
//		
//	}
	
	@Override
	public Ocena dodajOcenuZaZakljucivanje (long ocenaId,long zakljucnaOcenaId) {
		Ocena ocena = ocenaRepository.findById(ocenaId).get();
		ZakljucnaOcena zakljucnaOcena = zakljucnaOcenaService.findById(zakljucnaOcenaId);
		ocena.setZakljucivanjeOcena(zakljucnaOcena);
		return ocenaRepository.save(ocena);
		
	}
	
	

	
	

}
