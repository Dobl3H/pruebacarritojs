package com.akan2.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akan2.Models.RegistroModels;
import com.akan2.Repositories.RegistroRepository;



@Service
public class RegistroServices {
    @Autowired
    RegistroRepository registroRepository;

     public ArrayList<RegistroModels> obtenerEnvio(){
         return (ArrayList<RegistroModels>) registroRepository.findAll();
         }
     public RegistroModels guardarEnvio(RegistroModels envio){
            return registroRepository.save(envio);
        }
     public Optional<RegistroModels> obtenerPorId(Long id_guia_envio){
            return registroRepository.findById(id_guia_envio);
        }

     public boolean eliminarEnvio(Long id_guia_envio) {
            try{
                registroRepository.deleteById(id_guia_envio);
                return true;
            }catch(Exception err){
                return false;
            }
        }
}