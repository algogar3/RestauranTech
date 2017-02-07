package controller;

import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.Session;
import models.Mesa;
import vista.BotonMesa;

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
