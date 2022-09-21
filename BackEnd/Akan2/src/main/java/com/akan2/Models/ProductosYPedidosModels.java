package com.akan2.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "productos_y_pedidos")

public class ProductosYPedidosModels {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id_productos_pedidos;
	
	
	@ManyToOne
	@JoinColumn(nullable=false,name="id_producto")
	@JsonProperty(access=Access.WRITE_ONLY)
	private ProductoModel id_producto;
	
	
	@ManyToOne
	@JoinColumn(nullable=false,name="id_pedido")
	@JsonProperty(access=Access.WRITE_ONLY)
	private DetalleDePedidoModels id_pedido;


	public Long getId_productos_pedidos() {
		return id_productos_pedidos;
	}


	public void setId_productos_pedidos(Long id_productos_pedidos) {
		this.id_productos_pedidos = id_productos_pedidos;
	}


	public ProductoModel getId_producto() {
		return id_producto;
	}


	public void setId_producto(ProductoModel id_producto) {
		this.id_producto = id_producto;
	}


	public DetalleDePedidoModels getId_pedido() {
		return id_pedido;
	}


	public void setId_pedido(DetalleDePedidoModels id_pedido) {
		this.id_pedido = id_pedido;
	}
	
	
	
	
	
}
