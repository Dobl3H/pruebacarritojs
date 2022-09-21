package com.akan2.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akan2.Models.ArtistaModel;

@Repository
public interface ArtistaRepository extends CrudRepository<ArtistaModel,Long>{
	public abstract Optional<ArtistaModel> findById(Long id);

	
}
