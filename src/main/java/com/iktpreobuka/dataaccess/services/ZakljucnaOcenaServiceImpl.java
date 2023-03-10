package com.iktpreobuka.dataaccess.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.dataaccess.entities.ZakljucnaOcena;
import com.iktpreobuka.dataaccess.repositories.ZakljucnaOcenaRepository;

@Service
public class ZakljucnaOcenaServiceImpl implements ZakljucnaOcenaService {
	@Autowired
	private ZakljucnaOcenaRepository zakljucnaOcenaRepository;

	@Override
	public ZakljucnaOcena findById(long id){
		return zakljucnaOcenaRepository.findById(id).get();
	}

}