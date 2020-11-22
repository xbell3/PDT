package com.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Formulario implements Serializable {

	private static final long serialVersionUID = 1L;

	public Formulario() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idFormulario;
	
	@Column(length = 40, nullable=false, unique = true)
	private String nombreFormulario;
	
	@Column(length = 150)
	private String resumen;
	
//	//@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "formulario")
//	private List<Casilla> casillas;
//	
//	public List<Casilla> getCasillas() {
//		return casillas;
//	}
//
//	public void setCasillas(List<Casilla> casillas) {
//		this.casillas = casillas;
//	}

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



}