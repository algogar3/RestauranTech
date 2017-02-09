/*
 * Controlador que tiene como función introducir un nuevo 
 * empleado en la base de datos, o bien actualizar los 
 * atributos de un empleado ya existente
 * */

package controllers;

import org.hibernate.Session;

import models.Empleado;

public class ControladorInsertarActualizarEmpleados {
	
	public static void realizarTransaccionEmpleado(Session session, Empleado empleadoTemporal, boolean creandoEmpleado, Integer idEmpleado){
		
		// Se inicia la transacción
		session.beginTransaction();
		
		// Se comprueba el tipo de operación que se debe hacer
		if(creandoEmpleado){
			// Se debe introducir el empleado recibido en la base de datos
			session.persist(empleadoTemporal);
		}
		else{
			// Hay que actualizar un empleado existente en la base de datos
			// Se recupera de la base de datos el empleado con el id igual al id pasado como parámetro
			Empleado empleado = (Empleado) session.get(Empleado.class, idEmpleado);
			
			// Se introducen los nuevos valores en el empleado recuperado de la base de datos
			empleado.setNombre(empleadoTemporal.getNombre());
			empleado.setApellidos(empleadoTemporal.getApellidos());
			empleado.setPasswordEmpleado(empleadoTemporal.getPasswordEmpleado());
			empleado.setTelefono(empleadoTemporal.getTelefono());
			empleado.setDni(empleadoTemporal.getDni());
			empleado.setPermisos(empleadoTemporal.isPermisos());
			
			// Actualización del empleado
			session.persist(empleado);
		}
		
		// Persistencia de los datos
		session.getTransaction().commit();
	}
}
