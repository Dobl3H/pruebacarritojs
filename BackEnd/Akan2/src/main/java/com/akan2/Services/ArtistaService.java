package com.akan2.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akan2.Models.ArtistaModel;
import com.akan2.Repositories.ArtistaRepository;



@Service
public class ArtistaService {
	@Autowired
	private  ArtistaRepository artistaRepository;
	
	public ArrayList<ArtistaModel> obtenerArtista(){
		return (ArrayList<ArtistaModel>) artistaRepository.findAll();
    }
	
	//obtener usuario por id
	public ArtistaModel obtenerArtista(Long id) {
		Optional<ArtistaModel> user = artistaRepository.findById(id);
		return user.orElse(null);
	}
	
	public ArtistaModel guardarArtista(ArtistaModel artista){
        return artistaRepository.save(artista);
    }

	
	// eliminar
	public boolean eliminar(Long id) {
        try{
            artistaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
	
	//actualizar
	public ArtistaModel actualizar(ArtistaModel artistaModel) {
		return artistaRepository.save(artistaModel);
	}
}
