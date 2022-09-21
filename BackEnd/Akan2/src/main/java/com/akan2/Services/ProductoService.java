package com.akan2.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akan2.Models.ProductoModel;
import com.akan2.Repositories.ProductosRepositories;



@Service

public class ProductoService {
	

	@Autowired
	private ProductosRepositories productoRepository;

	public ArrayList<ProductoModel> obtenerProducto(){
		return (ArrayList<ProductoModel>) productoRepository.findAll();
    }
	
	//obtener usuario por id
	public ProductoModel obtenerProducto(Long id) {
		Optional<ProductoModel> post = productoRepository.findById(id);
		return post.orElse(null);
	}
	
	public ProductoModel guardarProducto(ProductoModel productoModel){
        return productoRepository.save(productoModel);
    }

	
	
	// eliminar
	public boolean eliminar(Long id) {
        try{
        	productoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
	
	

	//actualizar
	public ProductoModel actualizar(ProductoModel productoModel) {
		return productoRepository.save(productoModel);
	}

	
}




