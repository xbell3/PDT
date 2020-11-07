package com.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.ManyToMany;

@Entity
public class Rol implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idRol;
	
	@Column(length=40/*,unique=true*/)
	private String nombre;
	
	@Column(length=100)
	private String descripcion;
	
	/*@ManyToMany(fetch=FetchType.LAZY)
	private List<Funcionalidad> funcionalidades = new ArrayList<>();*/
	
	public Rol() {
		super();
	}



	public Long getIdRol() {
		return idRol;
	}



	public void setIdRol(Long idRol) {
		this.idRol = idRol;
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


