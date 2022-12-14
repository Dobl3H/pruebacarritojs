package com.akan2.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akan2.Models.UsuarioModel;
import com.akan2.Repositories.UsuarioRepository;


@Service
public class UsuarioService {
	
	@Autowired
	private  UsuarioRepository usuarioRepository;
	
	public ArrayList<UsuarioModel> obtenerUsuario(){
		return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }
	
	//obtener usuario por id
	public UsuarioModel obtenerUsuario(Long id) {
		Optional<UsuarioModel> user = usuarioRepository.findById(id);
		return user.orElse(null);
	}
	
	public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

	
	// eliminar
	public boolean eliminar(Long id) {
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


	//actualizar
	public UsuarioModel actualizar(UsuarioModel usuarioModel) {
		return usuarioRepository.save(usuarioModel);
	}
	
	
	//buscar por tel
	public ArrayList<UsuarioModel> obtenerPorTelefono(String telefono){
		return usuarioRepository.findByTelefono(telefono);
	}
	
	
	//buscar por prioridad
//	public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad) {
//		return usuarioRepository.findByPrioridad(prioridad);
//	}
}

