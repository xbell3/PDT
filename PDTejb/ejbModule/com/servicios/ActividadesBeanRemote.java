package com.servicios;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.Remote;

import com.entidades.Actividad;
import com.entidades.Usuario;
import com.exception.ServiciosException;

@Remote
public interface ActividadesBeanRemote {

	List<Actividad> obtenerRangoFechas(GregorianCalendar startFecha, GregorianCalendar endFecha);

	void crear(Actividad actividad) throws ServiciosException;

	void actualizar(Actividad actividad) throws ServiciosException;

	void borrar(Long idActividad) throws ServiciosException;

	List<Actividad> obtenerPorUsuarioExperto(String filtro);

	List<Actividad> obtenerPorEstacionMuestreo(String filtro);

}
