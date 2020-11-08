package com.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Usuario implements Serializable {

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 40)
	private String nombre;

	@Column(length = 40)
	private String apellido;

	@Column(length = 40)
	private String nombreUsuario;

	@Column(length = 40)
	private String correo;

	@Column(length = 40)
	private String contrasena;

	@OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL )
	@JoinColumn(name = "nombreRol")
	private Rol rol;
	
	
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Usuario() {
		super();
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	
}