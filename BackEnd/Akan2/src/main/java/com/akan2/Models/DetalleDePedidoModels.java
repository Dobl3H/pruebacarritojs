package com.akan2.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name = "detalle_de_pedido")
public class DetalleDePedidoModels {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	public Long id_pedido;
	
	@ManyToOne
    @JoinColumn(nullable = false, name = "id_cliente")
    @JsonProperty(access = Access.WRITE_ONLY)
	private UsuarioModel id_cliente;
	
	@Column(nullable = false)
	private Double precio_por_unidades;
	
	@Column(nullable = false)
	private Double unidades;
	
	@OneToMany(mappedBy="id_pedido")
	private List<ProductosYPedidosModels> productosypedidos;
	
	@OneToMany(mappedBy = "id_pedido")
    private List<EnvioModels> pedidoyenvio;
	
	@OneToMany(mappedBy = "id_pedido")
    private List<PagoModel> pedidoypago;

	public Long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public UsuarioModel getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(UsuarioModel id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Double getPrecio_por_unidades() {
		return precio_por_unidades;
	}

	public void setPrecio_por_unidades(Double precio_por_unidades) {
		this.precio_por_unidades = precio_por_unidades;
	}

	public Double getUnidades() {
		return unidades;
	}

	public void setUnidades(Double unidades) {
		this.unidades = unidades;
	}

	public List<ProductosYPedidosModels> getProductosypedidos() {
		return productosypedidos;
	}

	public void setProductosypedidos(List<ProductosYPedidosModels> productosypedidos) {
		this.productosypedidos = productosypedidos;
	}

	public List<EnvioModels> getPedidoyenvio() {
		return pedidoyenvio;
	}

	public void setPedidoyenvio(List<EnvioModels> pedidoyenvio) {
		this.pedidoyenvio = pedidoyenvio;
	}

	public List<PagoModel> getPedidoypago() {
		return pedidoypago;
	}

	public void setPedidoypago(List<PagoModel> pedidoypago) {
		this.pedidoypago = pedidoypago;
	}
	
	
	
	
	
}
