/*
 * Controlador que devuelve el servicio ACTIVO asociado a una mesa
 * */

package controllers;

import java.util.Iterator;

import org.hibernate.Session;

import models.Mesa;
import models.Servicio;

public class ControladorServicioActivoMesa {
	
	// M�todo obtenerServicioActivoMesa()
	public static Servicio obtenerServicioActivoMesa(Session session, int idMesa){
		
		// Variables
		Servicio servicio = new Servicio();
		
		// Se abre la sesi�n
		session.beginTransaction();
		
		// Se recupera un servicio que cumpla las siguientes condiciones:
		// 	* Tiene asociado un ID de mesa igual al pasado como par�metro en la declaraci�n del m�todo
		// 	* Su atributo "servicio_activo" es TRUE
		
		Iterator iter = session.createQuery("from Servicio").iterate();
		while(iter.hasNext()){
			servicio = (Servicio) iter.next();
			if(servicio.getMesa().getIdMesa() == idMesa && servicio.isServicioActivo()){
				// Se cumplen las condiciones descritas m�s arriba
				return servicio;
			}
		}
		return null;
	} 

}
