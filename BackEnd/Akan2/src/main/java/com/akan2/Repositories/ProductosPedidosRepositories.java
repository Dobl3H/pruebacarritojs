package com.akan2.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akan2.Models.ProductosYPedidosModels;


@Repository
public interface ProductosPedidosRepositories extends CrudRepository<ProductosYPedidosModels,Long> {
	
}
