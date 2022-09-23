package com.akan2.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akan2.Models.RegistroModels;
import com.akan2.Repositories.RegistroRepository;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import static java.util.Collections.emptyList;
import com.akan2.Models.RegistroModels;
import com.akan2.Repositories.RegistroRepository;


@Service
public class RegistroServices implements UserDetailsService {
 @Autowired
 RegistroRepository registroRepository;
 /* Para obtener el registro*/
 public ArrayList<RegistroModels> obtenerRegistro(){
  return (ArrayList<RegistroModels>) registroRepository.findAll();
 }
 // Para guardar un registro
 public RegistroModels guardarRegistro(RegistroModels registro) {
  return registroRepository.save(registro);
 }

 public Optional<RegistroModels> obtenerPorId(Integer id_registro){
        return registroRepository.findById(id_registro);
    }
 
 //public ArrayList<RegistroModels> obtenerPorEmail(String email) {
  //return registroRepository.findByEmail(email);
  
  
   
 
 
 public boolean eliminarRegistro(Integer id) {
        try{
         registroRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
 @Override
 public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
  RegistroModels user = registroRepository.findByEmail(email);
  
  if(user == null) {
            throw new UsernameNotFoundException(email);
        }
  
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), emptyList());
 }
 
 
}
