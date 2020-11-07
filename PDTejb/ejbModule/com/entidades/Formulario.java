package com.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "FORMULARIO")
public class Formulario implements Serializable {

	private static final long serialVersionUID = 1L;

	public Formulario() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idFormulario;

	@Column(length = 40)
	private String nombreFormulario;

	@Column(length = 150)
	private String resumen;
	
	@ManyToMany(mappedBy = "formularios" )
	private List<Casilla> casillas = new ArrayList<Casilla>();
	
	public Long getIdFormulario() {
		return idFormulario;
	}

	public void setIdFormulario(Long idFormulario) {
		this.idFormulario = idFormulario;
	}

	public String getNombreFormulario() {
		return nombreFormulario;
	}

	public void setNombreFormulario(String nombreFormulario) {
		this.nombreFormulario = nombreFormulario;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
