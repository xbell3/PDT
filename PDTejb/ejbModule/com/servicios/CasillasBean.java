package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entidades.Casilla;
import com.entidades.Formulario;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class CasillasBean
 */
@Stateless
public class CasillasBean implements CasillasBeanRemote {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public CasillasBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(Casilla casilla, String nombreFormulario) throws ServiciosException {
		try {
			Formulario formulario = em.createQuery(
			"SELECT f from Formulario f WHERE f.nombreFormulario = :nombreFormulario", Formulario.class).
			setParameter("nombreFormulario", nombreFormulario).getSingleResult();
			casilla.setFormulario(formulario);
			em.persist(casilla);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear la casilla");
		}
	}
	

	@Override
	public void actualizar(Casilla casilla) throws ServiciosException {
		try {
			em.merge(casilla);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar la casilla");
		}
	}
	@Override
	public void borrar(Long idCasilla) throws ServiciosException {
		try {
			Casilla casilla = em.find(Casilla.class, idCasilla);
			em.remove(casilla);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo borrar la casilla");
		}

	}

	@Override
	public List<Casilla> obtenerTodos() {
		TypedQuery<Casilla> query = em.createQuery("SELECT c FROM Casilla c", Casilla.class);
		return query.getResultList();
	}

	@Override
	public List<Casilla> obtenerTodos(String filtro) {
		TypedQuery<Casilla> query = em.createQuery("SELECT c FROM Casilla c WHERE c.parametro LIKE :parametro", Casilla.class)
				.setParameter("parametro", filtro);
		return query.getResultList();
	}
	@Override
	public List<Casilla> obtenerTodosPorFormulario(String filtro) {
		TypedQuery<Casilla> query = em.createQuery("SELECT c FROM Casilla c WHERE c.formulario.nombreFormulario LIKE :nombreFormulario", Casilla.class)
				.setParameter("nombreFormulario", filtro);
		return query.getResultList();
	}

}
