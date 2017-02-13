/*
 * Contolador que tiene por funci�n gestionar el apartado de 
 * cobros de la aplicaci�n. Por un lado registra la cantidad 
 * de dinero cobrada, almacenando dicha informaci�n en la base 
 * de datos. Por otro lado, ayuda al empleado para que sepa 
 * cuanto dinero tiene que devolver al cliente, en funci�n de 
 * lo que �ste le haya entregado.
 * */

package controllers;

import java.text.DecimalFormat;
import org.hibernate.Session;
import models.Facturacion;
import models.Servicio;

public class ControladorCobrosYFacturacion {
	
	// M�todo obtenerCambio()
	public static String obtenerCambio(Servicio servicio, double importeEntregadoDouble){
		// Variables
		double cambio;
		DecimalFormat df = new DecimalFormat("#.00");
		
		// Se devuelve el importe que el camarero tiene que devolverle al cliente
		 cambio = importeEntregadoDouble - servicio.getGasto().doubleValue();
		 return df.format(cambio);
	}
	
	// M�todo insertarFacturacion()
	public static void insertarFacturacion(Session session, Servicio servicio){
		
		// Se inicia la sesi�n
		session.beginTransaction();
		
		/*** FACTURACI�N ***/
		// Se instancia un nuevo objeto Facturacion
		Facturacion facturacion = new Facturacion();
		
		// Obtenci�n y seteo de los valores del nuevo objeto
		facturacion.setCantidadComensales(servicio.getComensales());
		facturacion.setCantidadFacturada(servicio.getGasto());
		facturacion.setFecha(servicio.getFecha());
		
		/*** SERVICIO ***/
		// Una vez se han introducido los datos de facturaci�n del servicio en la base 
		// de datos, se cambia su estado
		servicio.setServicioActivo(false);
		
		// Persistencia de los datos
		session.persist(facturacion);
		session.persist(servicio);
	}

}
