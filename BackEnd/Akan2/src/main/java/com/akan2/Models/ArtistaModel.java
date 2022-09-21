package com.akan2.Models;

import javax.persistence.*;

import java.util.List;


@Entity
@Table(name = "artistas")
public class ArtistaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id_artista;
	private String nombre;
	private String categoria;
	private String telefono;
	private String facebook;
	private String instagram;
	private String tiktok;
	
	@OneToMany(mappedBy = "artista")
    private List<ProductoModel> posts;

	public Long getId_artista() {
		return id_artista;
	}

	public void setId_artista(Long id_artista) {
		this.id_artista = id_artista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getTiktok() {
		return tiktok;
	}

	public void setTiktok(String tiktok) {
		this.tiktok = tiktok;
	}

	public List<ProductoModel> getPosts() {
		return posts;
	}

	public void setPosts(List<ProductoModel> posts) {
		this.posts = posts;
	}
	


	
	
}

