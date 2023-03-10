package com.iktpreobuka.dataaccess.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.dataaccess.entities.Roditelj;
import com.iktpreobuka.dataaccess.repositories.RoditeljRepository;

@Service
public class RoditeljServiceImpl implements RoditeljService {
	
	@Autowired
	private RoditeljRepository roditeljRepository;
	
	@Override
	public Roditelj findById(int id) {
		
		return roditeljRepository.findById(id).get();
	}
}
