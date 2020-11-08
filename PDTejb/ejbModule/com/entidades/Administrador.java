package com.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Administrador
 *
 */
@Entity
public class Administrador extends Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Administrador() {
		super();
	}
   
}
