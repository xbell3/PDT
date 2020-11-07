package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entidades.Funcionalidad;
import com.exception.ServiciosException;

@Remote
public interface FuncionalidadBeanRemote {

	List<Funcionalidad> obtenerTodos(String filtro);

	List<Funcionalidad> obtenerTodos();

	void borrar(Long id) throws ServiciosException;

	void actualizar(Funcionalidad f) throws ServiciosException;

	void crear(Funcionalidad f) throws ServiciosException;

}
