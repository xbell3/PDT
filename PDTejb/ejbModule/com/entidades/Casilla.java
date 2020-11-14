package com.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Casilla implements Serializable {

	private static final long serialVersionUID = 1L;

	public Casilla() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idCasilla;

	@Column(length = 40)
	private String parametro;

	@Column(length = 40)
	private String unidadMedida;

	@Column(length = 150)
	private String descripcion;
	
	@Column(length = 40)
	private String tipoUnidad;

//	@ManyToOne(fetch=FetchType.LAZY)
//	private Formulario formulario; 
//
//	
//	public Formulario getFormulario() {
//		return formulario;
//	}
//
//	public void setFormulario(Formulario formulario) {
//		this.formulario = formulario;
//	}

	public String getTipoUnidad() {
		return tipoUnidad;
	}

	public void setTipoUnidad(String tipoUnidad) {
		this.tipoUnidad = tipoUnidad;
	}

	public Long getIdCasilla() {
		return idCasilla;
	}

	public void setIdCasilla(Long idCasilla) {
		this.idCasilla = idCasilla;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
