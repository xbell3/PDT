package com.cliente;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entidades.Formulario;
import com.entidades.Rol;
import com.entidades.Usuario;
import com.exception.ServiciosException;
import com.servicios.FormulariosBeanRemote;
import com.servicios.RolBeanRemote;
import com.servicios.UsuariosBeanRemote;

public class Principal {

	public static void main(String[] args) throws NamingException {
		
		UsuariosBeanRemote usuariosBeanRemote = (UsuariosBeanRemote) InitialContext.doLookup("PDTejb/UsuariosBean!com.servicios.UsuariosBeanRemote");
		RolBeanRemote rolBeanRemote = (RolBeanRemote) InitialContext.doLookup("PDTejb/RolBean!com.servicios.RolBeanRemote");
		FormulariosBeanRemote formulariosBeanRemote = (FormulariosBeanRemote) InitialContext.doLookup("PDTejb/FormulariosBean!com.servicios.FormulariosBeanRemote");

		
	Formulario formulario = new Formulario();	
	Usuario usuario = new Usuario();
	Rol rol = new Rol();
	
	formulario.setNombreFormulario("Agua");
	formulario.setResumen("Este formulario sera para todo el manejo del agua");
	List<Formulario> formularios = new ArrayList<>();
	formularios = formulariosBeanRemote.obtenerTodos();
	for (Formulario f : formularios) {
		System.out.println("Se obtiene el " + f);
	}
	System.out.println("Se creó exitosamente el formulario");

}

}
