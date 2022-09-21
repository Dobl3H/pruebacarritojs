package com.akan2.Models;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "envio")

public class EnvioModels {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id_guia_envio;
	
	@ManyToOne
    @JoinColumn(nullable = false, name = "id_pedido")
    @JsonProperty(access = Access.WRITE_ONLY)
	private DetalleDePedidoModels id_pedido;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date fecha;
	
	@PrePersist
	private void onCreate() {                                                             
		fecha = new Date();
	}
	
	

	public Long getId_guia_envio() {
		return id_guia_envio;
	}


	public void setId_guia_envio(Long id_guia_envio) {
		this.id_guia_envio = id_guia_envio;
	}


	public DetalleDePedidoModels getId_pedido() {
		return id_pedido;
	}


	public void setId_pedido(DetalleDePedidoModels id_pedido) {
		this.id_pedido = id_pedido;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	
	


	
}

