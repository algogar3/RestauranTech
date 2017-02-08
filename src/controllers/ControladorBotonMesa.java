/*
 * Controlador que tiene como funci�n obtener las ID de las mesas
 * disponibles en la base de datos. Para ello, se hace una consulta
 * de todas las mesas, y se almacenan sus ID en un ArrayList.
 * Posteriormente se utilizar� el contenido de este ArrayList para 
 * asignar cada mesa (mediante su ID) a un bot�n.
 * */

package controllers;

import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.Session;
import models.Mesa;
import vistas.BotonMesa;

public class ControladorBotonMesa {
	
	public static ArrayList<Integer> devolverIdMesa(Session session){
		ArrayList<Integer> arrayIdMesas = new ArrayList<Integer>();
		Iterator iter = session.createQuery("from Mesa").iterate();
		while(iter.hasNext()){
			Mesa mesa = (Mesa) iter.next();
			arrayIdMesas.add(mesa.getIdMesa());
		}
		return arrayIdMesas;
	}

}
