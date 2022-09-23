package com.akan2.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akan2.Models.RegistroModels;



@Repository 
public interface RegistroRepository extends CrudRepository<RegistroModels,Integer>{
	public abstract RegistroModels findByEmail(String email);
}


