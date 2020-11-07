package com.cliente;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entidades.Rol;
import com.entidades.Usuario;
import com.exception.ServiciosException;
import com.servicios.RolBeanRemote;

public class MainRol {

	public static void main(String[] args) throws NamingException {

		
		RolBeanRemote rolBean = (RolBeanRemote)InitialContext.doLookup("PDTejb/RolBean!com.servicios.RolBeanRemote");
		Rol asd = new Rol();
		asd.setNombre("Administrador");
		asd.setDescripcion("descripcion de admin2");
		Rol asd1 = new Rol();
		asd1.setDescripcion("descripcion de experto");
		asd1.setNombre("Experto");
		try {
			rolBean.crear(asd);
			System.out.println("Se creó exitosamente el rol");
		rolBean.crear(asd1);
		System.out.println("Se creó exitosamente el otro rol");
		} catch (ServiciosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	/*	List<Rol> roles = new ArrayList<>();
		roles = rolBean.obtenerTodos();
		for (Rol r : roles){
			System.out.println("Nombre: " + r.getNombre() + "  " + "Descripcion: " + r.getDescripcion());
		}*/
		System.out.println("-----------------------------------------");

	}

}
