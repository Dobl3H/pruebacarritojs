package com.akan2.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akan2.Models.PagoModel;
import com.akan2.Repositories.PagoRepositories;



@Service

public class PagoServices {
	@Autowired
	PagoRepositories pagorepositories;
	
	public ArrayList<PagoModel> obtenerPago(){
		return (ArrayList<PagoModel>)pagorepositories.findAll();
		
	}
	public PagoModel guardarPago(PagoModel usuario){
        return pagorepositories.save(usuario);
    }
	
	public Optional<PagoModel> obtenerPorId(Long id){
        return pagorepositories.findById(id);
    }
	
	public boolean eliminarPago(Long id) {
        try{
        	pagorepositories.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }




}
