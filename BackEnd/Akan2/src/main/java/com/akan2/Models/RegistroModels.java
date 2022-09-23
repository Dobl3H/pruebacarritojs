package com.akan2.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity 
@Table (name= "Registros")

public class RegistroModels {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
	private Integer id_registro;
	
	private String nombre_usuario;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
    private String password;
	
	//relacion con usuario models
	@OneToMany( mappedBy = "registro")
	private  List<UsuarioModel> id_registro2;
	
	 
	//@Temporal(TemporalType.DATE)
	private String fecha_nacimiento;
	
	
	public List<UsuarioModel> getId_registro2() {
		return id_registro2;
	}
	public void setId_registro2(List<UsuarioModel> id_registro2) {
		this.id_registro2 = id_registro2;
	}
	public Integer getId_registro() {
		return id_registro;
	}
	public void setId_registro(Integer id_registro) {
		this.id_registro = id_registro;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
	
	
	
}


