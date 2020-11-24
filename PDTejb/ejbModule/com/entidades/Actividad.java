package com.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Actividad
 *
 */
@Entity

public class Actividad implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Actividad() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idActividad;
	
	@Column(length = 20)
	private String fechaInicio;
	
	@Column(length = 20)
	private String fechaFin;
	
	@Column(length = 40)
	private String nombreFormulario;
   
	@Column(length = 40)
	private String nombreUsuario;
	
	@Column(length = 40)
	private String rol;
	
	@Column(length = 40)
	private String metodoMuestreo;
	
	@Column(length = 40)
	private String estacionMuestreo;
	
	@Column(length = 40)
	private String departamento;

	public Long getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}



	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getNombreFormulario() {
		return nombreFormulario;
	}

	public void setNombreFormulario(String nombreFormulario) {
		this.nombreFormulario = nombreFormulario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getMetodoMuestreo() {
		return metodoMuestreo;
	}

	public void setMetodoMuestreo(String metodoMuestreo) {
		this.metodoMuestreo = metodoMuestreo;
	}

	public String getEstacionMuestreo() {
		return estacionMuestreo;
	}

	public void setEstacionMuestreo(String estacionMuestreo) {
		this.estacionMuestreo = estacionMuestreo;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}



	
}
