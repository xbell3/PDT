package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entidades.Formulario;
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
	public List<Formulario> obtenerTodos() {
		TypedQuery<Formulario> query = em.createQuery("SELECT m FROM Formulario m",Formulario.class); 
		return query.getResultList();
	}

	@Override
	public List<Formulario> obtenerTodos(String filtro) {
		TypedQuery<Formulario> query = em.createQuery("SELECT M FROM Formulario m WHERE m.nombre LIKE :nombre",Formulario.class)
				.setParameter("nombre", filtro);
		return query.getResultList();
	}
}
