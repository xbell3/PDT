package com.cliente;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entidades.Casilla;
import com.entidades.Formulario;
import com.entidades.Rol;
import com.entidades.Usuario;
import com.exception.ServiciosException;
import com.servicios.CasillasBeanRemote;
import com.servicios.FormulariosBeanRemote;
import com.servicios.RolBeanRemote;
import com.servicios.UsuariosBeanRemote;

public class Principal {

	public static void main(String[] args) throws NamingException, ServiciosException {
		
		UsuariosBeanRemote usuariosBeanRemote = (UsuariosBeanRemote) InitialContext.doLookup("PDTejb/UsuariosBean!com.servicios.UsuariosBeanRemote");
		RolBeanRemote rolBeanRemote = (RolBeanRemote) InitialContext.doLookup("PDTejb/RolBean!com.servicios.RolBeanRemote");
		FormulariosBeanRemote formulariosBeanRemote = (FormulariosBeanRemote) InitialContext.doLookup("PDTejb/FormulariosBean!com.servicios.FormulariosBeanRemote");
		CasillasBeanRemote casillasBeanRemote = (CasillasBeanRemote) InitialContext.doLookup("PDTejb/CasillasBean!com.servicios.CasillasBeanRemote");

	Casilla casilla = new Casilla();
	Formulario formulario1 = new Formulario();	
	Usuario usuario = new Usuario();
	Rol rol = new Rol();
	//---------------------------------------
	formulario1.setNombreFormulario("Clima");
	formulario1.setResumen("Este formulario sera para todo el manejo del Clima");
	formulariosBeanRemote.crear(formulario1);
	System.out.println("Se creó exitosamente el formulario");

	//---------------------------------------
	
	casilla.setParametro("Longitud");
	casilla.setDescripcion("a");
	casillasBeanRemote.crear(casilla);
	System.out.println("Se creó exitosamente la casilla");

	//---------------------------------------
	formulariosBeanRemote.asignarCasilla(17L, 18L);
	
	List<Formulario> formularios;
	formularios = formulariosBeanRemote.obtenerTodos();
	for(Formulario formulario : formularios){
		System.out.println(formulario+" Se asigno exitosamente la casilla la formulario");

	}
	System.out.println("Se asigno exitosamente la casilla la formulario");


}

}
