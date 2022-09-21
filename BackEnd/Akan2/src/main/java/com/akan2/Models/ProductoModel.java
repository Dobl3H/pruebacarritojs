package com.akan2.Models;


import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name = "productos")
public class ProductoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id_producto;
	
	@Column(nullable = false, length = 255)
	private String nombre_producto;
	private Double precio;
	
	@Column(columnDefinition = "text")
	private String descripcion;
	
    @ManyToOne
    @JoinColumn(nullable = false, name = "id_artista")
    @JsonProperty(access = Access.WRITE_ONLY)
    private ArtistaModel artista;
    
    @OneToMany(mappedBy = "id_producto")
    private List<ProductosYPedidosModels> productospedidos;
    

	public Long getId_producto() {
		return id_producto;
	}

	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ArtistaModel getArtista() {
		return artista;
	}

	public void setArtista(ArtistaModel artista) {
		this.artista = artista;
	}
    
    
    
	
}

