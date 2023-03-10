package com.iktpreobuka.dataaccess.services;

import com.iktpreobuka.dataaccess.entities.Ucenik;

public interface UcenikService {
	

	public Ucenik dodajOdeljenjeUceniku(int ucenikId, int odeljenjeId);
	public Ucenik dodajRoditeljaUceniku(int ucenikId, int roditeljId);
	public Ucenik findById(int id);
	public Ucenik dodajPredmetUceniku(int ucenikId, int predmetId);
	
}
