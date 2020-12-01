package com.entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
	private GregorianCalendar fechaInicio;
	
	@Column(length = 20)
	private GregorianCalendar fechaFin;
	
	@Column(length = 40)
	private String nombreFormulario;
   
	@Column(length = 40)
	private String nombreUsuario;
	
	@Column(length = 40)
	private String metodoMuestreo;
	
	@Column(length = 40)
	private String estacionMuestreo;
	
	@Column(length = 40)
	private String departamento;
	
	@OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "rolUsuario")
	private Rol rol;

	@Column(length = 40)
	private String casilla1;
	
	@Column(length = 40)
	private String casilla2;

	@Column(length = 40)
	private String casilla3;

	@Column(length = 40)
	private String casilla4;

	@Column(length = 40)
	private String casilla5;

	@Column(length = 40)
	private String casilla6;

	@Column(length = 40)
	private String casilla7;

	@Column(length = 40)
	private String casilla8;

	@Column(length = 40)
	private String casilla9;

	@Column(length = 40)
	private String casilla10;


	public Long getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}

	public GregorianCalendar getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(GregorianCalendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public GregorianCalendar getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(GregorianCalendar fechaFin) {
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

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}


	
}
