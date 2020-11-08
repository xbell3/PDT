package com.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import com.entidades.Usuario;

/**
 * Entity implementation class for Entity: Rol
 *
 */
@Entity

public class Rol implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Rol() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idRol;

	@Column(length = 40, name ="nombreRol")
	private String nombreRol;

	
	public Long getIdRol() {
		return idRol;
	}


	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}




	public String getNombreRol() {
		return nombreRol;
	}


	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	
	
	
}
