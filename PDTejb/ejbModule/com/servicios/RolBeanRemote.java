package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entidades.Rol;
import com.exception.ServiciosException;

@Remote
public interface RolBeanRemote {
	
	void crear(Rol rol) throws ServiciosException;
	
	void actualizar(Rol rol) throws ServiciosException;
	
	void borrar(Long id) throws ServiciosException;
	
	List<Rol> obtenerTodos();
	
	List<Rol> obtenerTodos(String filtro);

}

