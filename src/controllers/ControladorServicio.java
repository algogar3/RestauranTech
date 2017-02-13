/*
 * Controlador que tiene como función hacer una inserción en la 
 * base de datos de un nuevo servicio. Se actualizará el valor 
 * del ID de la mesa, el ID del camamrero que abre la mesa, el 
 * numero de comensales y la fecha. En este momento se asignará 
 * un gasto de 0.0 euros. Conforme se vayan actualizando las 
 * comandas de la mesa, se irá actualizando también el valor del 
 * gasto.
 * */

package controllers;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;

import models.Empleado;
import models.Mesa;
import models.Servicio;

public class ControladorServicio {

	// Metodo insertarNuevoServicio()
	public static void insertarNuevoServicio(Session session, int idMesa, int idEmpleado, int numeroComensales, Date fecha){
		
		// Se inicia la sesion
		session.beginTransaction();
		
		// Se instancia un nuevo objeto servicio
		Servicio servicio = new Servicio();
		
		/*** OBTENCIÓN DE VALORES ***/
		// Mesa
		Mesa mesa = (Mesa) session.get(Mesa.class, idMesa);
		// Empleado
		Empleado empleado = (Empleado) session.get(Empleado.class, idEmpleado);
		// Gasto
		Double gasto = 0.0;
		
		/*** SETEO DE VALORES ***/
		servicio.setMesa(mesa);
		servicio.setEmpleado(empleado);
		servicio.setComensales(numeroComensales);
		servicio.setGasto(new BigDecimal(gasto));
		servicio.setFecha(fecha);
		servicio.setServicioActivo(true);
		
		// Persistencia de los datos
		session.persist(servicio);
		session.getTransaction().commit();
	}
}
