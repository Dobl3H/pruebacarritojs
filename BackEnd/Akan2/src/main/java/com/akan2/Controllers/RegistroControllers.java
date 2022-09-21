package com.akan2.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.akan2.Models.RegistroModels;
import com.akan2.Services.RegistroServices;






@RestController
@RequestMapping("/registro")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
public class RegistroControllers {
    @Autowired
    RegistroServices registroServices;

    @GetMapping()
    public ArrayList<RegistroModels> obtenerEnvio(){
        return registroServices.obtenerEnvio();

    }
    @PostMapping()
    public RegistroModels guardarEnvio(@RequestBody RegistroModels envio){
        return this.registroServices.guardarEnvio(envio);
    }
    @GetMapping( path = "/{id}")
    public Optional<RegistroModels> obtenerEnvioPorId(@PathVariable("id")Long id_guia_envio) {
        return this.registroServices.obtenerPorId(id_guia_envio);
    }


    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id_guia_envio){
        boolean ok = this.registroServices.eliminarEnvio(id_guia_envio);
        if (ok){
            return "Se eliminó el envio con id " + id_guia_envio;
        }else{
            return "No pudo eliminar el envio con id" + id_guia_envio;
        }
    }

}
