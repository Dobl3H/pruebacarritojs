package com.akan2.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.akan2.Models.EnvioModels;
import com.akan2.Services.EnvioServices;





@RestController
@RequestMapping("/envio")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })

public class EnvioControllers {
	@Autowired
	EnvioServices envioServices;
	
	@GetMapping()
	public ArrayList<EnvioModels> obtenerEnvio(){
        return envioServices.obtenerEnvio();
        
    }
	@PostMapping()
	public EnvioModels guardarEnvio(@RequestBody EnvioModels envio){
        return this.envioServices.guardarEnvio(envio);
    }
	@GetMapping( path = "/{id}")
	public Optional<EnvioModels> obtenerEnvioPorId(@PathVariable("id")Long id_guia_envio) {
        return this.envioServices.obtenerPorId(id_guia_envio);
    }
	
    
	@DeleteMapping( path = "/{id}")
	public String eliminarPorId(@PathVariable("id") Long id_guia_envio){
        boolean ok = this.envioServices.eliminarEnvio(id_guia_envio);
        if (ok){
            return "Se eliminó el envio con id " + id_guia_envio;
        }else{
            return "No pudo eliminar el envio con id" + id_guia_envio;
        }
    }
	
}



