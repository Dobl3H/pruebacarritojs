package com.akan2.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.akan2.Models.ArtistaModel;
import com.akan2.Services.ArtistaService;



@RestController
@RequestMapping("/artista")

public class ArtistaController {
	
	@Autowired
	ArtistaService artistaService;
	
	//obtener todos los usuarios
	@GetMapping() // http://localhost:8080/usuario
	public ArrayList<ArtistaModel> obtenerArtista(){
        return artistaService.obtenerArtista();
    }
	
	@GetMapping("/{id}")  // http://localhost:8080/usuario/1
	public ArtistaModel getArtista(@PathVariable Long id) {
		return artistaService.obtenerArtista(id);
	} 
	
	//Buscar por prioridad   
//	@GetMapping("/query")  // http://localhost:8080/usuario/query?prioridad=4
//	public ArrayList<ArtistaModel> obtenerArtistaPorPrioridad(@RequestParam("prioridad") Integer prioridad){
//        return this.artistaService.obtenerPorPrioridad(prioridad);
//    }

	
	@PostMapping()  // http://localhost:8080/usuario
	public ArtistaModel guardarArtista(@RequestBody ArtistaModel artista){
        return artistaService.guardarArtista(artista);
    }

	// Editar usuario
	@PutMapping("/actualizar") //http://localhost:8080/usuario/actualizar
	public ArtistaModel update(@RequestBody ArtistaModel artistaModel) {
		return artistaService.actualizar(artistaModel);
	}
	
	//Eliminar usuario
	@DeleteMapping("/eliminar/{id}") //http://localhost:8080/usuario/eliminar/1
		public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.artistaService.eliminar(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id " + id;
        }
    }
		
}

