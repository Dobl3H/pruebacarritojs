package com.akan2.Repositories;



import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akan2.Models.UsuarioModel;



@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel,Long>{
	public abstract ArrayList<UsuarioModel> findByTelefono(String telefono);
}
