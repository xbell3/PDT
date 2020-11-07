package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entidades.Formulario;
import com.exception.ServiciosException;

@Remote
public interface FormulariosBeanRemote {

	void actualizar(Formulario formulario) throws ServiciosException;

	void crear(Formulario formulario) throws ServiciosException;

	void borrar(Long idFormulario) throws ServiciosException;

	List<Formulario> obtenerTodos(String filtro);

	List<Formulario> obtenerTodos();

}
