package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entidades.Casilla;
import com.entidades.Formulario;
import com.exception.ServiciosException;

@Remote
public interface CasillasBeanRemote {

	void crear(Casilla casilla, String nombreFormulario) throws ServiciosException;

	void actualizar(Casilla casilla) throws ServiciosException;

	void borrar(Long idCasilla) throws ServiciosException;

	List<Casilla> obtenerTodos();

	List<Casilla> obtenerTodos(String filtro);

}
