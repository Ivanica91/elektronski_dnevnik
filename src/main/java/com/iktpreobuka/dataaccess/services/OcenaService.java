package com.iktpreobuka.dataaccess.services;

import com.iktpreobuka.dataaccess.entities.Ocena;

public interface OcenaService {
	
	public Ocena findById(long id);
//	public Ocena dodajOcenuUceniku (long ocenaId, int ucenikId);
	public Ocena dodajOcenuZaZakljucivanje (long ocenaId, long zakljucnaOcenaId);
	
}
