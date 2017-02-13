/*
 * Contolador que tiene por funci�n gestionar el apartado de 
 * cobros de la aplicaci�n. Por un lado registra la cantidad 
 * de dinero cobrada, almacenando dicha informaci�n en la base 
 * de datos. Por otro lado, ayuda al empleado para que sepa 
 * cuanto dinero tiene que devolver al cliente, en funci�n de 
 * lo que �ste le haya entregado.
 * */

package controllers;

import org.hibernate.Session;

import models.Facturacion;
import models.Servicio;

public class ControladorCobrosYFacturacion {
	
	// Variables
	
	// M�todo obtenerCambio()
	public static double obtenerCambio(double gastoMesa, double importeEntregado){
		// Se devuelve el importe que el camarero tiene que devolverle al cliente
		return importeEntregado - gastoMesa;
	}
	
	// M�todo insertarFacturacion()
	public static void insertarFacturacion(Session session, Servicio servicio){
		
		// Se inicia la sesi�n
		session.beginTransaction();
		
		// Se instancia un nuevo objeto Facturacion
		Facturacion facturacion = new Facturacion();
		
		// Obtenci�n y seteo de los valores del nuevo objeto
		facturacion.setCantidadComensales(servicio.getComensales());
		facturacion.setCantidadFacturada(servicio.getGasto());
		facturacion.setFecha(servicio.getFecha());
		
		// Persistencia de los datos
		session.persist(facturacion);
		
		// Una vez se ha cobrado la mesa y se ha introducido la factura en la base de datos,
		// se cambia el estado de la mesa
		//EstadoMesa.dejarMesaLibre(session, idBotonMesa);
	}

}
