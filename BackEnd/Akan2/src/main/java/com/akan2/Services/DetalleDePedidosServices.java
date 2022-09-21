package com.akan2.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akan2.Models.DetalleDePedidoModels;
import com.akan2.Repositories.DetalleDePedidosRepositories;


@Service

public class DetalleDePedidosServices {
	@Autowired
	DetalleDePedidosRepositories detalledepedidorepositories;
	
	public ArrayList<DetalleDePedidoModels> obtenerDetalleDepedido(){
		return (ArrayList<DetalleDePedidoModels>)detalledepedidorepositories.findAll();
		
	}
	public DetalleDePedidoModels guardarDetalleDepedido(DetalleDePedidoModels usuario){
        return detalledepedidorepositories.save(usuario);
    }
	
	public Optional<DetalleDePedidoModels> obtenerPorId(Long id){
        return detalledepedidorepositories.findById(id);
    }
	
	public boolean eliminarDetalledepedido(Long id) {
        try{
        	detalledepedidorepositories.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }




}
