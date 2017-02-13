/*
 * Controlador que tiene como funci�n comprobar si una mesa 
 * est� abierta o no. De esta manera no se podr� abrir una 
 * mesa varias veces, y no se podr�n asignar comandas a mesas 
 * no abiertas.
 * 
 * El controlador se compone de un m�todo que devolver� un 
 * booleano. Su valor ser� TRUE si la mesa est� abierta, y 
 * FALSE si la mesa no est� abierta.
 * */

package controllers;

import org.hibernate.Session;
import models.Mesa;

public class EstadoMesa {
	
	// M�todo comprobarEstadoMesa
	public static boolean comprobarEstadoMesa(Session session, int idBotonMesa){
		// Se recupera el objeto mesa cuya ID es igual a la que se pasa como 
		// par�metro en la definici�n del m�todo
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
	
	// M�todo dejarMesaLibre()
	public static void dejarMesaLibre(Session session, int idBotonMesa){
		// Se recupera el objeto mesa cuya ID es igual a la que se pasa como 
		// par�metro en la definici�n del m�todo
		Mesa mesa = (Mesa) session.get(Mesa.class, idBotonMesa);
		session.beginTransaction();
		
		// Modificaci�n del estado de la mesa
		mesa.setOcupada(false);
		
		// Se guarda el nuevo estado de la mesa
		session.update(mesa);
		session.getTransaction().commit();
	}
}


