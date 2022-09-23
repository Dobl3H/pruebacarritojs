package com.akan2.Models;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table (name = "pago")

public class PagoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;
    
    @ManyToOne
    @JoinColumn(nullable = false, name = "id_pedido")
    @JsonProperty(access = Access.WRITE_ONLY)
    private DetalleDePedidoModels id_pedido;
    
    
    private String nombreUsuarioTarjeta;
    private String numTarjeta;
    private Integer yearTarjeta;
    private Integer mesTarjeta;
    private Integer ccv;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public DetalleDePedidoModels getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(DetalleDePedidoModels id_pedido) {
		this.id_pedido = id_pedido;
	}
	public String getNombreUsuarioTarjeta() {
		return nombreUsuarioTarjeta;
	}
	public void setNombreUsuarioTarjeta(String nombreUsuarioTarjeta) {
		this.nombreUsuarioTarjeta = nombreUsuarioTarjeta;
	}
	public String getNumTarjeta() {
		return numTarjeta;
	}
	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	public Integer getYearTarjeta() {
		return yearTarjeta;
	}
	public void setYearTarjeta(Integer yearTarjeta) {
		this.yearTarjeta = yearTarjeta;
	}
	public Integer getMesTarjeta() {
		return mesTarjeta;
	}
	public void setMesTarjeta(Integer mesTarjeta) {
		this.mesTarjeta = mesTarjeta;
	}
	public Integer getCcv() {
		return ccv;
	}
	public void setCcv(Integer ccv) {
		this.ccv = ccv;
	}
	

    
}