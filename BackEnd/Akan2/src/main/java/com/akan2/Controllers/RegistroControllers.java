package com.akan2.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
//@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        //RequestMethod.PUT })

public class RegistroControllers {
 //@Autowired
 //RegistroServices registroServices;
 
 private final RegistroServices registroServices;
 private final BCryptPasswordEncoder bCryptPasswordEncoder;
 public RegistroControllers(@Autowired RegistroServices registroServices, @Autowired BCryptPasswordEncoder bCryptPasswordEncoder) {
 this.registroServices = registroServices;
 this.bCryptPasswordEncoder = bCryptPasswordEncoder;
 }
 
 @GetMapping()
 public ArrayList<RegistroModels> obtenerRegistro(){
         return registroServices.obtenerRegistro();
 }
 @PostMapping()
 public RegistroModels guardarRegistros(@RequestBody RegistroModels registro){
  registro.setPassword(bCryptPasswordEncoder.encode(registro.getPassword()));
        return registroServices.guardarRegistro(registro);
    }
 /*@GetMapping(path = "/query")
 public ArrayList<RegistroModels> obtenerPorEmail(@RequestParam("email")String email){
  return this.registroServices.obtenerPorEmail(email);
 }*/
 @GetMapping( path = "/{id}")
 public Optional<RegistroModels> obtenerRegistrosPorId(@PathVariable("id") Integer id_registro) {
        return this.registroServices.obtenerPorId(id_registro);
    }
 @DeleteMapping( path = "/{id}")
 public String eliminarPorId(@PathVariable("id_registro") Integer id){
        boolean ok = this.registroServices.eliminarRegistro(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }

}