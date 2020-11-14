package com.servicios;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import com.entidades.Actividad;
import com.entidades.Casilla;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class ActividadesBean
 */
@Stateless
public class ActividadesBean implements ActividadesBeanRemote {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ActividadesBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(Actividad actividad) throws ServiciosException {
		try {
			em.persist(actividad);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear la actividad");
		}
	}

	@Override
	public void actualizar(Actividad actividad) throws ServiciosException {
		try {
			em.merge(actividad);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar la actividad");
		}
	}

	@Override
	public void borrar(Long idActividad) throws ServiciosException {
		try {
			Actividad actividad = em.find(Actividad.class, idActividad);
			em.remove(actividad);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo borrar la casilla");
		}

	}

	@Override
	public List<Actividad> obtenerRangoFechas(Calendar startFecha, Calendar endFecha) {
		List<Actividad> query = em
				.createQuery("SELECT e FROM Events e WHERE e.eventsDate BETWEEN :startFecha AND :endFecha",
						Actividad.class)
				.setParameter("startFecha", startFecha, TemporalType.TIMESTAMP)
				.setParameter("endFecha", endFecha, TemporalType.TIMESTAMP).getResultList();
		return query;

	}

	@Override
	public List<Actividad> obtenerPorMetodoMuestreo(String filtro) {
		TypedQuery<Actividad> query = em
				.createQuery("SELECT m FROM Actividad m WHERE m.metodoMuestreo LIKE :metodoMuestreo", Actividad.class)
				.setParameter("metodoMuestreo", filtro);
		return query.getResultList();
	}

	@Override
	public List<Actividad> obtenerPorEstacionMuestreo(String filtro) {
		TypedQuery<Actividad> query = em
				.createQuery("SELECT m FROM Actividad m WHERE m.estacionMuestreo LIKE :estacionMuestreo",
						Actividad.class)
				.setParameter("estacionMuestreo", filtro);
		return query.getResultList();
	}

}
