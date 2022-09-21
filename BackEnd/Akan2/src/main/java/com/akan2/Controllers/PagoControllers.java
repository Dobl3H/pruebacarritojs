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

import com.akan2.Models.PagoModel;
import com.akan2.Services.PagoServices;



@RestController
@RequestMapping("/metodopago")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })

public class PagoControllers {
	@Autowired
	PagoServices pagoServices;
	@GetMapping()
	public ArrayList<PagoModel> obtenerPago(){
	        return pagoServices.obtenerPago();
	}
	@PostMapping()
	public PagoModel guardarPago(@RequestBody PagoModel usuario){
        return this.pagoServices.guardarPago(usuario);
    }
	@GetMapping( path = "/{id}")
	public Optional<PagoModel> obtenerPagoPorId(@PathVariable("id") Long id) {
        return this.pagoServices.obtenerPorId(id);
    }
	@DeleteMapping( path = "/{id}")
	public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.pagoServices.eliminarPago(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }

}

