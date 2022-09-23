package com.akan2.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akan2.Models.UsuarioModel;
import com.akan2.Services.UsuarioService;




@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	//obtener todos los usuarios
	@GetMapping() // http://localhost:8080/usuario
	public ArrayList<UsuarioModel> obtenerUsuario(){
        return usuarioService.obtenerUsuario();
    }
	
	@GetMapping("/{id}")  // http://localhost:8080/usuario/1
	public UsuarioModel getUsuario(@PathVariable Long id) {
		return usuarioService.obtenerUsuario(id);
	} 
	
	@PostMapping()  // http://localhost:8080/usuario
	public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return usuarioService.guardarUsuario(usuario);
    }

	// Editar usuario
	@PutMapping("/actualizar") //http://localhost:8080/usuario/actualizar
	public UsuarioModel update(@RequestBody UsuarioModel usuarioModel) {
		return usuarioService.actualizar(usuarioModel);
	}
	
	//Eliminar usuario
	@DeleteMapping("/eliminar/{id}") //http://localhost:8080/usuario/eliminar/1
		public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminar(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id " + id;
        }
    }
	
	//Obtener el usuario por telefono
	@GetMapping("/query")
	public ArrayList<UsuarioModel> obtenerPorTelefono(@RequestParam("telefono") String telefono){
		return this.usuarioService.obtenerPorTelefono(telefono);
	}
	
	
}
