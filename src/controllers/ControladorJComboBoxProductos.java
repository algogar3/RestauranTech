/*
 * Controlador que tiene como función devolver un ArrayList con 
 * información de cada producto, para mostrarla en un menú 
 * desplegable (JComboBox)
 * */

package controllers;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;

import models.Producto;

public class ControladorJComboBoxProductos {
	
	// Variables
	private static ArrayList<Producto> listaProductos;
	
	// Método obtenerListaProductos()
	public static ArrayList<Producto> obtenerListaProductos(Session session){
		// Inicialización de variables
		listaProductos = new ArrayList<Producto>();
		
		// Se recuperan todos los productos de la base de datos 
		Iterator iter = session.createQuery("from Producto").iterate();
		while(iter.hasNext()){
			Producto producto = (Producto) iter.next();
			listaProductos.add(producto);
		}
		
		// Retorno del método
		return listaProductos;
	}
}
