package com.iktpreobuka.dataaccess.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.dataaccess.entities.Admin;

public interface AdminRepository extends CrudRepository<Admin,Integer > {
	
}
