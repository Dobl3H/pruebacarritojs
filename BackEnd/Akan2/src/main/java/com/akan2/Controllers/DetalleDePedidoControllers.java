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

import com.akan2.Models.DetalleDePedidoModels;
import com.akan2.Services.DetalleDePedidosServices;



@RestController
@RequestMapping("/detalledepedido")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })

public class DetalleDePedidoControllers {
	@Autowired
	DetalleDePedidosServices detalledepedidoServices;
	@GetMapping()
	public ArrayList<DetalleDePedidoModels> obtenerDetalleDepedido(){
	        return detalledepedidoServices.obtenerDetalleDepedido();
	}
	@PostMapping()
	public DetalleDePedidoModels guardarDetalleDepedido(@RequestBody DetalleDePedidoModels usuario){
        return this.detalledepedidoServices.guardarDetalleDepedido(usuario);
    }
	@GetMapping( path = "/{id}")
	public Optional<DetalleDePedidoModels> obtenerPagoPorId(@PathVariable("id") Long id) {
        return this.detalledepedidoServices.obtenerPorId(id);
    }
	@DeleteMapping( path = "/{id}")
	public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.detalledepedidoServices.eliminarDetalledepedido(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }

}
