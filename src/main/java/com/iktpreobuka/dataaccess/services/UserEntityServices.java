package com.iktpreobuka.dataaccess.services;

import java.util.Optional;

import com.iktpreobuka.dataaccess.entities.UserEntity;

public interface UserEntityServices {
	
	public Optional<UserEntity> findById (Integer id);

}
