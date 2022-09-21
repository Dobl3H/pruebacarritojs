package com.akan2.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RestController;

import com.akan2.Models.ProductoModel;
import com.akan2.Services.ProductoService;



@RestController
@RequestMapping("/galeria")

public class ProductoController {
	@Autowired
	private ProductoService productoService;
	
	// obtener todos los posts
	@GetMapping() // http://localhost:8080/producto
	public ArrayList<ProductoModel> obtenerProducto() {
		return productoService.obtenerProducto();
	}

	@GetMapping("/{id}") // http://localhost:8080/producto/1
	public ProductoModel getProducto(@PathVariable Long id) {
		return productoService.obtenerProducto(id);
	}

	@PostMapping() // http://localhost:8080/posts
	public ProductoModel guardarProducto(@RequestBody ProductoModel productoModel) {
		return productoService.guardarProducto(productoModel);
	}

	// Editar usuario
	@PutMapping("/actualizar") // http://localhost:8080/posts/actualizar
	public ProductoModel update(@RequestBody ProductoModel productoModel) {
		return productoService.actualizar(productoModel);
	}

	// Eliminar usuario
	@DeleteMapping("/eliminar/{id}") // http://localhost:8080/posts/eliminar/1
	public void eliminar(@PathVariable Long id) {
		productoService.eliminar(id);
	}
		
}
