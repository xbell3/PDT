package com.cliente;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entidades.Rol;
import com.entidades.Usuario;
import com.exception.ServiciosException;
import com.servicios.RolBean;
import com.servicios.RolBeanRemote;
import com.servicios.UsuariosBeanRemote;



public class Consola {

	public static void main(String[] args) throws NamingException {
		
		RolBeanRemote rolBean = (RolBeanRemote)InitialContext.doLookup("PDTejb/RolBean!com.servicios.RolBeanRemote");
			/*	rolBean.crear(admin2);
			System.out.println("Se creó exitosamente el rol");
			rolBean.crear(experto);
			System.out.println("Se creó exitosamente el otro rol");
*/
			List<Rol> roles = rolBean.obtenerTodos();
			for (Rol r : roles){
				System.out.println(r.getNombre());
			}
			System.out.println("-----------------------------------------");
	
	
	
	
		/*Rol experto = new Rol();
		experto.setNombre("Experto");
		admin.setId(2L);

		try {
			rolBean.crear(experto);
			System.out.println("Se creó exitosamente el rol");
		
		} catch (ServiciosException e) {
			System.out.println(e.getMessage());
		} 
		
		Rol comun = new Rol();
		comun.setNombre("Común");
		admin.setId(3L);

		try {
			rolBean.crear(comun);
			System.out.println("Se creó exitosamente el rol");
		
		} catch (ServiciosException e) {
			System.out.println(e.getMessage());
		} 

	}*/
		
		//List<Rol> roles = new ArrayList<>();
		
		//List<Rol> roles = rolBean.obtenerTodos("Experto");	
		//Rol rol = roles.get(0);	
		
		//Usuario usuario = new Usuario();
		//usuario.setRol(rol);
		//System.out.println(rol);
		
		System.out.println("-----------------------------------------");
		System.out.println("Obtengo todos las roles: ");
		System.out.println("-----------------------------------------");
		
		// modifico un rol
		
				/*try {
					admin.setNombre("Prueba");
					rolBean.actualizar(admin);
					System.out.println("Se modificó exitosamente el rol");
				} catch (ServiciosException e) {
					System.out.println(e.getMessage());
				}*/
		
		
		//elimino el rol
		/*
				try {
					rolBean.borrar(1l);
					System.out.println("Se eliminó exitosamente el rol");
				} catch (ServiciosException e) {
					System.out.println(e.getMessage());
				}
		*/
	
	}
}


