package com.cliente;


import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entidades.Casilla;
import com.entidades.Formulario;
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

		
//		Formulario formulario4 = new Formulario();
//		formulario4.setNombreFormulario("Clima");
//		formulario4.setResumen("Este formulario sera para todo el manejo del Clima");
//		formulariosBeanRemote.crear(formulario4);
//		System.out.println("Se creó exitosamente el formulario");
//		
		//---------------------------------------
		
//			Formulario f5 = new Formulario();
//			f5.setNombreFormulario("Prueba de form 5");
//			formulariosBeanRemote.crear(f5);		
//			System.out.println("Se creo formulario existosamente");
//			
		//---------------------------------------
		Casilla casilla1 = new Casilla();

		Formulario formulario = new Formulario();
		
		formulario.setNombreFormulario("Uno21");
		formulariosBeanRemote.crear(formulario);
		System.out.println("Se creó exitosamente el formulario1");
		
		//---------------------------------------
		Formulario formulario2 = new Formulario();
		
		formulario2.setNombreFormulario("Dos123");
		formulariosBeanRemote.crear(formulario2);
		System.out.println("Se creó exitosamente el formulario2");
		
		//---------------------------------------
		Formulario formulario3 = new Formulario();
		
		formulario3.setNombreFormulario("Tres123");
		formulariosBeanRemote.crear(formulario3);
		System.out.println("Se creó exitosamente el formulario3");
		
		//---------------------------------------
		casilla1.setDescripcion("Nueva casilla 600");
		casillasBeanRemote.crear(casilla1 , "Uno1");
		System.out.println("Se creó exitosamente la casilla");

    	//---------------------------------------
		Casilla casilla2 = new Casilla();
		casilla2.setDescripcion("Nueva casilla 1600");
		casillasBeanRemote.crear(casilla2 , "Uno1");
		System.out.println("Se creó exitosamente la casilla");
    	//---------------------------------------
		Casilla casilla3 = new Casilla();
		casilla3.setDescripcion("Nueva casilla 2600");
		casillasBeanRemote.crear(casilla3 , "Uno1");
		System.out.println("Se creó exitosamente la casilla");
    	//---------------------------------------
		Casilla casilla4 = new Casilla();
		casilla4.setDescripcion("Nueva casilla 3600");
		casillasBeanRemote.crear(casilla4 , "Uno1" );
		System.out.println("Se creó exitosamente la casilla");
    	//---------------------------------------
//	    List<Casilla> casillas = new ArrayList<>();
//    	casillasBeanRemote.crear(casillas);
//    	System.out.println("Hasta aca llegue 1");
//	    for(Casilla c : casillas){
//	    	System.out.println("Hasta aca llegue 2");
//	    	c.setFormulario(formulario4);
//	    	c.setUnidadMedida("Grados");
//	    	c.setTipoUnidad("numerico");
//	    	c.setParametro("Longitud");
//	    	c.setDescripcion("a");
//	    	casillas.add(c);    	
//	    	System.out.println("Se creó exitosamente la casilla");
//	    }	

//	formulariosBeanRemote.obtenerPorNombreFormulario("Prueba");
//	
//	System.out.println("Se listo exitosamente");


}

}
