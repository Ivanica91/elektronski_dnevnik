package com.iktpreobuka.dataaccess.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.dataaccess.entities.UserEntity;
import com.iktpreobuka.dataaccess.repositories.UserRepository;

@Service
public class UserEntityServicesImpl implements UserEntityServices{
	
	@Autowired
	private UserRepository userRepository;
	
	public Optional<UserEntity> findById(Integer id) {
		return userRepository.findById(id);
	}
}
