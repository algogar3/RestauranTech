/*
 * Controlador que tiene como funci�n comprobar si el login 
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
import vistas.PanelPad.OnBotonPulsado;

public class Login {
	
	// Variables
	private static boolean empleadoEncontrado;
	private static OnLogeo escuchador;
	
	// M�todo comprobarLogin()
	public static Empleado comprobarLogin(Session session, String password){
		// Inicializaci�n de las variables
		empleadoEncontrado = false;
		// Se recuperan todos los empleados de la base de datos
		Iterator iter = session.createQuery("from Empleado").iterate();
		while(iter.hasNext() && empleadoEncontrado == false){
			Empleado empleado = (Empleado) iter.next();
			// Comprobaci�n de los datos para cada empleado
			if(String.valueOf(empleado.getPasswordEmpleado()).equals(password)){
				// Se ha encontrado al usuario
				empleadoEncontrado = true;
				escuchador.usuarioLogeado(empleado);
				System.out.println(empleado.getNombre() + " " + empleado.getApellidos() + " se ha logeado correctamente");
				return empleado;
			}
		}
		// Si se recorren todos los empleados y no se han encontrado coincidencias, se devuelve null
		System.out.println("Intento de logeo fallido");
		return null;
	}
	
	// Interfaz OnLogeo
	public interface OnLogeo{
		public void usuarioLogeado(Empleado empleado);
	}
	
	// M�todo de suscripci�n a la interfaz
	public void setOnLogeo(OnLogeo escuchador){
		this.escuchador = escuchador;
	}
}
