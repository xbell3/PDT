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
	public void crear(Casilla casilla) throws ServiciosException {
		try {
			em.persist(casilla);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear la Casilla");
		}
	}

	@Override
	public void actualizar(Casilla casilla) throws ServiciosException {
		try {
			em.merge(casilla);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar la Casilla");
		}
	}

	@Override
	public void borrar(Long idCasilla) throws ServiciosException {
		try {
			Casilla casilla = em.find(Casilla.class, idCasilla);
			em.remove(casilla);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo borrar la Casilla");
		}

	}

	@Override
	public List<Casilla> obtenerTodos() {
		TypedQuery<Casilla> query = em.createQuery("SELECT m FROM Casilla m", Casilla.class);
		return query.getResultList();
	}

	@Override
	public List<Casilla> obtenerTodos(String filtro) {
		TypedQuery<Casilla> query = em.createQuery("SELECT M FROM Casilla m WHERE m.nombre LIKE :nombre", Casilla.class)
				.setParameter("nombre", filtro);
		return query.getResultList();
	}
}
