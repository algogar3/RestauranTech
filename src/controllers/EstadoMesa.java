/*
 * Controlador que tiene como función comprobar si una mesa 
 * está abierta o no. De esta manera no se podrá abrir una 
 * mesa varias veces, y no se podrán asignar comandas a mesas 
 * no abiertas.
 * 
 * El controlador se compone de un método que devolverá un 
 * booleano. Su valor será TRUE si la mesa está abierta, y 
 * FALSE si la mesa no está abierta.
 * */

package controllers;

import org.hibernate.Session;
import models.Mesa;

public class EstadoMesa {
	
	// Método comprobarEstadoMesa
	public static boolean comprobarEstadoMesa(Session session, int idBotonMesa){
		// Se recupera el objeto mesa cuya ID es igual a la que se pasa como 
		// parámetro en la definición del método
		Mesa mesa = (Mesa) session.get(Mesa.class, idBotonMesa);
		session.beginTransaction();
		// Se comprueba el valor del atributo ocupada
		if(mesa.isOcupada()){
			return true;
		}
		else{
			mesa.setOcupada(true);
			session.update(mesa);
			session.getTransaction().commit();
			return false;
		}	
	}
	
	// Método dejarMesaLibre()
	public static void dejarMesaLibre(Session session, int idBotonMesa){
		// Se recupera el objeto mesa cuya ID es igual a la que se pasa como 
		// parámetro en la definición del método
		Mesa mesa = (Mesa) session.get(Mesa.class, idBotonMesa);
		session.beginTransaction();
		
		// Modificación del estado de la mesa
		mesa.setOcupada(false);
		
		// Se guarda el nuevo estado de la mesa
		session.update(mesa);
		session.getTransaction().commit();
	}
}


