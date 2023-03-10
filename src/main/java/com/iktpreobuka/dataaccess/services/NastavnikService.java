package com.iktpreobuka.dataaccess.services;

import com.iktpreobuka.dataaccess.entities.Nastavnik;

public interface NastavnikService {
	
//	public Nastavnik findById(int id);
	public Nastavnik dodajPredmetNastavniku(int nastavnikId, int predmetId);
	public Nastavnik dodajOdeljenjeNastavniku (int nastavnikId,int odeljenjeId);
}
