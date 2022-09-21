package com.akan2.Models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;




@Entity
@Table(name = "usuarios")

public class UsuarioModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	
	private long id_cliente;
	@Column(nullable = false)
    private String password;
	
	private String nombre_usuario;
	private String apellido;
	private String direccion;
	private String telefono;
	
	@ManyToOne
    @JoinColumn(nullable = false, name = "id_registro")
	@JsonProperty(access = Access.WRITE_ONLY)
    private RegistroModels registro;
	//AQUI------------------------------------------------------------
	@OneToMany(mappedBy = "id_cliente")
    private List<DetalleDePedidoModels> usuarioydetallepedido;

	public long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public RegistroModels getRegistro() {
		return registro;
	}

	public void setRegistro(RegistroModels registro) {
		this.registro = registro;
	}

	public List<DetalleDePedidoModels> getUsuarioydetallepedido() {
		return usuarioydetallepedido;
	}

	public void setUsuarioydetallepedido(List<DetalleDePedidoModels> usuarioydetallepedido) {
		this.usuarioydetallepedido = usuarioydetallepedido;
	}
	
	
	
	
	


}
