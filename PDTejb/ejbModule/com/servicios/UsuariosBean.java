package com.servicios;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.entidades.Usuario;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class UsuariosBean
 */
@Stateless
public class UsuariosBean implements UsuariosBeanRemote {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public UsuariosBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(Usuario usuario) throws ServiciosException {
		try {
			em.persist(usuario);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear el usuario");
		}
	}

	@Override
	public void actualizar(Usuario usuario) throws ServiciosException {
		try {
			em.merge(usuario);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar la materia");
		}
	}

	@Override
	public void borrar(Long idUsuario) throws ServiciosException {
		try {
			Usuario usuario = em.find(Usuario.class, idUsuario);
			em.remove(usuario);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo borrar la materia");
		}

	}

	@Override
	public List<Usuario> obtenerTodos() {
		TypedQuery<Usuario> query = em.createQuery("SELECT m FROM Usuario m", Usuario.class);
		return query.getResultList();
	}

	@Override
	public List<Usuario> obtenerPorNombre(String filtro) {
		TypedQuery<Usuario> query = em.createQuery("SELECT m FROM Usuario m WHERE m.nombre LIKE :nombre", Usuario.class)
				.setParameter("nombre", filtro);
		return query.getResultList();
	}

	@Override
	public List<Usuario> obtenerPorApellido(String filtro) {
		TypedQuery<Usuario> query = em
				.createQuery("SELECT m FROM Usuario m WHERE m.apellido LIKE :apellido", Usuario.class)
				.setParameter("apellido", filtro);
		return query.getResultList();
	}

	@Override
	public List<Usuario> obtenerPorNombreUsuario(String filtro) {
		TypedQuery<Usuario> query = em
				.createQuery("SELECT m FROM Usuario m WHERE m.nombreUsuario LIKE :nombreUsuario", Usuario.class)
				.setParameter("nombreUsuario", filtro);
		return query.getResultList();
	}

	@Override
	public boolean obtenerNombre(String filtro) {
		try {
			TypedQuery<Usuario> query = em.createQuery("SELECT m FROM Usuario m WHERE m.nombreUsuario = :nombreUsuario",
					Usuario.class);
			query.setParameter("nomrbeUsuario", filtro);
			try {
				Usuario m = (Usuario) query.getResultList();
				return true;
			} catch (javax.persistence.NoResultException e) {
				return false;
			}
		} finally {
		}
	}

	@Override
	public boolean login(String nombreUsuario, String contrasena) {
		try {
			TypedQuery<Usuario> query = em.createQuery(
					"SELECT m FROM Usuario m WHERE m.nombreUsuario = :nombreUsuario AND m.contrasena = :contrasena",
					Usuario.class);
			query.setParameter("nombreUsuario", nombreUsuario);
			query.setParameter("contrasena", contrasena);
			try {
				Usuario m = query.getSingleResult();
				return true;
			} catch (javax.persistence.NoResultException e) {
				return false;
			}
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public boolean registro(String nombreUsuario) {
		try {
			TypedQuery<Usuario> query = em.createQuery("SELECT m FROM Usuario m WHERE m.nombreUsuario = :nombreUsuario",
					Usuario.class);
			query.setParameter("nombreUsuario", nombreUsuario);
			try {
				Usuario m = query.getSingleResult();
				return true;
			} catch (javax.persistence.NoResultException e) {
				return false;
			}
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public List<Usuario> obtenerTodos(String filtro) {
		TypedQuery<Usuario> query = em.createQuery("SELECT m FROM Usuario m WHERE m.nombre LIKE :nombre", Usuario.class)
				.setParameter("nombre", filtro);
		return query.getResultList();
	}

}
