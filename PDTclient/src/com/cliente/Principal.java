package com.cliente;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entidades.Usuario;
import com.exception.ServiciosException;
import com.servicios.UsuariosBeanRemote;

public class Principal {

	public static void main(String[] args) throws NamingException {
		
		UsuariosBeanRemote usuariosBeanRemote = (UsuariosBeanRemote) InitialContext.doLookup("ModuloEJB/UsuariosBean!com.servicios.UsuariosBeanRemote");
	
	
	Usuario usuario = new Usuario();
	usuario.setNombre("Raul");
	usuario.setApellido("Perez");
	usuario.setContrasena("quer99234");
	usuario.setNombreUsuario("Raul.Perez");
	usuario.setCorreo("Raul.Perez");

	try {
		usuariosBeanRemote.crear(usuario);
		System.out.println("Se creó exitosamente el departamento");
	} catch (ServiciosException e) {
		System.out.println(e.getMessage());
	}
	/*
	Rol admin = new Rol();
	admin.setId(1L);
	admin.setNombre("Administrador");

	try {
		RolBean.crear(admin);
		System.out.println("Se creó exitosamente el rol");
		
	} catch (ServiciosException e) {
		System.out.println(e.getMessage());
	} */

}

}
