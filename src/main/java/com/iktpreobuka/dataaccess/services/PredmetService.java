package com.iktpreobuka.dataaccess.services;

import com.iktpreobuka.dataaccess.entities.Predmet;

public interface PredmetService {

	 public Predmet findById(int id);
	 public Predmet dodajOcenuPredmetu (int predmetId, long ocenaId);


}
