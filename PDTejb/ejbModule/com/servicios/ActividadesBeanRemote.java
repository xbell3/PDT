package com.servicios;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Remote;

import com.entidades.Actividad;
import com.exception.ServiciosException;

@Remote
public interface ActividadesBeanRemote {

	List<Actividad> obtenerRangoFechas(Calendar startFecha, Calendar endFecha);

	void crear(Actividad actividad) throws ServiciosException;

	void actualizar(Actividad actividad) throws ServiciosException;

	void borrar(Long idActividad) throws ServiciosException;

	List<Actividad> obtenerPorMetodoMuestreo(String filtro);

	List<Actividad> obtenerPorEstacionMuestreo(String filtro);

}
