package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entidades.Casilla;
import com.entidades.Formulario;
import com.entidades.Usuario;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class FormulariosBean
 */
@Stateless
public class FormulariosBean implements FormulariosBeanRemote {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public FormulariosBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(Formulario formulario) throws ServiciosException {
		try {
			em.persist(formulario);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear el formulario");
		}
	} 

	@Override
	public void actualizar(Formulario formulario) throws ServiciosException {
		try {
			em.merge(formulario);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar el formulario");
		}
	}

	@Override
	public void borrar(Long idFormulario) throws ServiciosException {
		try {
			Formulario formulario = em.find(Formulario.class, idFormulario);
			em.remove(formulario);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo borrar el formulario");
		}

	}
	
	@Override
	public List<Formulario> obtenerTodosAsc() {
		TypedQuery<Formulario> query = em.createQuery("SELECT f FROM Formulario f ORDER BY f.nombreFormulario", Formulario.class);
		return query.getResultList();
	}
	
	@Override
	public List<Formulario> obtenerTodosDesc() {
		TypedQuery<Formulario> query = em.createQuery("SELECT f FROM Formulario f ORDER BY f.nombreFormulario DESC", Formulario.class);
		return query.getResultList();
	}
	
	@Override
	public List<Formulario> obtenerTodos() {
		TypedQuery<Formulario> query = em.createQuery("SELECT f FROM Formulario f", Formulario.class);
		return query.getResultList();
	}

	@Override
	public List<Formulario> obtenerTodos(String filtro) {
		TypedQuery<Formulario> query = em.createQuery("SELECT f FROM Formulario f WHERE f.nombreFormulario LIKE :nombreFormulario",Formulario.class)
				.setParameter("nombreFormulario", filtro);
		return query.getResultList();
	}
	
	@Override
	public boolean registro(String nombreFormulario) {
		try {
			TypedQuery<Formulario> query = em.createQuery("SELECT f FROM Formulario f WHERE f.nombreFormulario = :nombreFormulario",
					Formulario.class);
			query.setParameter("nombreFormulario", nombreFormulario);
			try {
				Formulario f = query.getSingleResult();
				return true;
			} catch (javax.persistence.NoResultException e) {
				return false;
			}
		} catch (Exception e) {
			throw e;
		}

	}
	@Override
	public List<Formulario> obtenerPorNombreFormulario(String filtro) {
		TypedQuery<Formulario> query = em
				.createQuery("SELECT f FROM Formulario f WHERE f.nombreFormulario LIKE :nombreFormulario", Formulario.class)
				.setParameter("nombreFormulario", filtro);
		return query.getResultList();
	}
}