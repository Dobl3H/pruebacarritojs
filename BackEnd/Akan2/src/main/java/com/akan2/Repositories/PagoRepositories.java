package com.akan2.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akan2.Models.PagoModel;


@Repository
public interface PagoRepositories extends CrudRepository<PagoModel,Long> {
	
}