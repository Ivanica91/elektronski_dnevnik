package com.iktpreobuka.dataaccess.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.dataaccess.entities.Odeljenje;
import com.iktpreobuka.dataaccess.repositories.OdeljenjeRepository;
@Service
public class OdeljenjeServiceImpl implements OdeljenjeService {

	@Autowired
	private OdeljenjeRepository odeljenjeRepository;
	
	
	@Override
	public Odeljenje findById(int id) {
		
		return odeljenjeRepository.findById(id).get();
	}

}
