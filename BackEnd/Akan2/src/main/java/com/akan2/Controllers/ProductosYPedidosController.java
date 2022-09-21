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

import com.akan2.Models.ProductosYPedidosModels;
import com.akan2.Services.ProductosYpedidosServices;



@RestController
@RequestMapping("/productosypedidos")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })

public class ProductosYPedidosController {
	@Autowired
	ProductosYpedidosServices productoypedidoServices;
	
	
	@GetMapping()
	public ArrayList<ProductosYPedidosModels> obtenerProductosyPedidos(){
	        return productoypedidoServices.obtenerProductosyPedidos();
	}
	@PostMapping()
	public ProductosYPedidosModels guardarProductosyServicios(@RequestBody ProductosYPedidosModels usuario){
        return this.productoypedidoServices.guardarProductosyPedidos(usuario);
    }
	@GetMapping( path = "/{id}")
	public Optional<ProductosYPedidosModels> obtenerProductosyPedidosPorId(@PathVariable("id") Long id) {
        return this.productoypedidoServices.obtenerPorId(id);
    }
	@DeleteMapping( path = "/{id}")
	public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.productoypedidoServices.eliminarProductosyPedidos(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }

}
