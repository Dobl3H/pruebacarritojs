package com.akan2.Repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akan2.Models.ProductoModel;



@Repository
public interface ProductosRepositories extends CrudRepository<ProductoModel,Long> {
	
}