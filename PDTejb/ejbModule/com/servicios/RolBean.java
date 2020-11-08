package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entidades.Rol;
import com.entidades.Usuario;
import com.exception.ServiciosException;


@Stateless
public class RolBean implements RolBeanRemote {

    //
    public RolBean() {
    }
    
    @PersistenceContext
	private EntityManager em;

	@Override
	public void crear(Rol rol) throws ServiciosException {
		try {
			
			em.persist(rol);
			em.flush();
			
		} catch(PersistenceException e) {	
			
			throw new ServiciosException("No se pudo crear el rol");
			
		}
		
	}
		
	

	@Override
	public void actualizar(Rol rol) throws ServiciosException {
		
		try {
			
			em.merge(rol);
			
		} catch(PersistenceException e) {
			
			throw new ServiciosException("No se pudo actualizar el rol");
		}
		
	}
		
	

	@Override
	public void borrar(Long id) throws ServiciosException {
		
		try {
			
			Rol rol = em.find(Rol.class, id);
			em.remove(rol);
			em.flush();
			
		} catch(PersistenceException e) {
			
			throw new ServiciosException("No se pudo borrar el rol");
		}
		
	}
		
	

	@Override
	public List<Rol> obtenerTodos() {
		TypedQuery<Rol> query = em.createQuery("SELECT m FROM Rol m", Rol.class);
		return query.getResultList();
	}

	@Override
	public List<Rol> obtenerTodos(String filtro) {
		
		TypedQuery<Rol>query = em.createQuery("SELECT r FROM Rol r WHERE r.nombreRol LIKE :nombreRol", Rol.class)
				.setParameter("nombreRol", filtro);
		return query.getResultList();
		
	}

}