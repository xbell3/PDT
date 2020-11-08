package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entidades.Funcionalidad;
import com.exception.ServiciosException;


@Stateless
public class FuncionalidadBean implements FuncionalidadBeanRemote {

    public FuncionalidadBean() {
    }
    
    @PersistenceContext
   	private EntityManager em;

	@Override
	public void crear(Funcionalidad f) throws ServiciosException {
		
		try {
			
			em.persist(f);
			em.flush();
			
		} catch(PersistenceException e) {	
			
			throw new ServiciosException("No se pudo crear la funcionalidad");
			
		}
		
	}

	@Override
	public void actualizar(Funcionalidad f) throws ServiciosException {
		
		try {
			
			em.merge(f);
			
		} catch(PersistenceException e) {
			
			throw new ServiciosException("No se pudo actualizar la funcionalidad");
		}
		
	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		
		try {
			
			Funcionalidad f = em.find(Funcionalidad.class, id);
			em.remove(f);
			em.flush();
			
		} catch(PersistenceException e) {
			
			throw new ServiciosException("No se pudo borrar la funcionalidad");
		}
		
	}

	@Override
	public List<Funcionalidad> obtenerTodos() {
		
		TypedQuery<Funcionalidad> query = em.createQuery("SELECT f FROM Funcionalidad f", Funcionalidad.class); 
		return query.getResultList();
	}

	@Override
	public List<Funcionalidad> obtenerTodos(String filtro) {
		
		TypedQuery<Funcionalidad>query = em.createQuery("SELECT f FROM Funcionalidad f WHERE f.nombre LIKE :nombre", Funcionalidad.class).setParameter("nombre", filtro);
		return query.getResultList();
	}

}
