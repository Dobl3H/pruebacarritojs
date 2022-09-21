package com.akan2.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akan2.Models.ProductosYPedidosModels;
import com.akan2.Repositories.ProductosPedidosRepositories;


@Service

public class ProductosYpedidosServices {
	@Autowired
	ProductosPedidosRepositories productoypedidorepositories;
	
	public ArrayList<ProductosYPedidosModels> obtenerProductosyPedidos(){
		return (ArrayList<ProductosYPedidosModels>)productoypedidorepositories.findAll();
		
	}
	public ProductosYPedidosModels guardarProductosyPedidos(ProductosYPedidosModels usuario){
        return productoypedidorepositories.save(usuario);
    }
	
	public Optional<ProductosYPedidosModels> obtenerPorId(Long id){
        return productoypedidorepositories.findById(id);
    }
	
	public boolean eliminarProductosyPedidos(Long id) {
        try{
        	productoypedidorepositories.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }




}
