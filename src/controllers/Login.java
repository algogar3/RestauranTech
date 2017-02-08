/*
 * Controlador que tiene como función comprobar si el login 
 * de un usuario es correcto o no. Se reciben los datos de 
 * ID y PASSWORD de la vista y se contrastan con los campos 
 * de la base de datos. Si el login es correcto se devuelve 
 * el empleado cuyos datos han obtenido la coincidencia. En 
 * caso contrario, se devuelve null.
 * */

package controllers;

import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.Session;
import models.Empleado;

public class Login {
	
	// Variables
	private static boolean empleadoEncontrado;
	
	// Método comprobarLogin()
	public static Empleado comprobarLogin(Session session, String id, String password){
		// Inicialización de las variables
		empleadoEncontrado = false;
		// Se recuperan todos los empleados de la base de datos
		Iterator iter = session.createQuery("from Empleado").iterate();
		while(iter.hasNext() && empleadoEncontrado == false){
			Empleado empleado = (Empleado) iter.next();
			// Comprobación de los datos para cada empleado
			if(String.valueOf(empleado.getIdEmpleado()).equals(id) && String.valueOf(empleado.getPasswordEmpleado()).equals(password)){
				// Se ha encontrado al usuario
				empleadoEncontrado = true;
				System.out.println("coincidencia");
				return empleado;
			}
		}
		// Si se recorren todos los empleados y no se han encontrado coincidencias, se devuelve null
		System.out.println("NO coincidencia");
		return null;
	}
}
