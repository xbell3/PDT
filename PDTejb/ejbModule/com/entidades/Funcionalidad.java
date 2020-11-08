package com.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.ManyToMany;

@Entity
public class Funcionalidad implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idFuncionalidad;
	
	@Column(length=40)
	private String nombre;
	
	@Column(length=100)
	private String descripcion;
	

	
	public Funcionalidad() {
		super();
	}

	

	public Long getIdFuncionalidad() {
		return idFuncionalidad;
	}



	public void setIdFuncionalidad(Long idFuncionalidad) {
		this.idFuncionalidad = idFuncionalidad;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	
	
}