package com.akan2.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akan2.Models.EnvioModels;
import com.akan2.Repositories.EnvioRepositorys;




@Service
public class EnvioServices {
	@Autowired
	EnvioRepositorys envioRepositorys;
	
	 public ArrayList<EnvioModels> obtenerEnvio(){
		 return (ArrayList<EnvioModels>) envioRepositorys.findAll();
		 }
	 public EnvioModels guardarEnvio(EnvioModels envio){
	        return envioRepositorys.save(envio);
	    }
	 public Optional<EnvioModels> obtenerPorId(Long id_guia_envio){
	        return envioRepositorys.findById(id_guia_envio);
	    }
	 
	 public boolean eliminarEnvio(Long id_guia_envio) {
	        try{
	        	envioRepositorys.deleteById(id_guia_envio);
	            return true;
	        }catch(Exception err){
	            return false;
	        }
	    }
	 
}
