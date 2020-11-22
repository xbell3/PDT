package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entidades.Casilla;
import com.entidades.Formulario;
import com.exception.ServiciosException;

@Remote
public interface FormulariosBeanRemote {

	boolean registro(String nombreFormulario);

	List<Formulario> obtenerTodos(String filtro);

	List<Formulario> obtenerTodos();

	void borrar(Long idFormulario) throws ServiciosException;

	void actualizar(Formulario formulario) throws ServiciosException;

	void crear(Formulario formulario) throws ServiciosException;

	List<Formulario> obtenerPorNombreFormulario(String filtro);

}
