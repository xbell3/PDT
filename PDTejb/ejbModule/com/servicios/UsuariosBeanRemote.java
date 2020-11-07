package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entidades.Usuario;
import com.exception.ServiciosException;

@Remote
public interface UsuariosBeanRemote {

	void crear(Usuario usuario) throws ServiciosException;

	void actualizar(Usuario usuario) throws ServiciosException;

	void borrar(Long idUsuario) throws ServiciosException;

	List<Usuario> obtenerPorNombre(String filtro);

	List<Usuario> obtenerTodos();
	
	List<Usuario> obtenerPorApellido(String filtro);

	List<Usuario> obtenerPorNombreUsuario(String filtro);

	boolean login(String nombreUsuario, String contrasena);

	boolean obtenerNombre(String filtro);

	List<Usuario> obtenerTodos(String filtro);

	boolean registro(String nombreUsuario);
}
