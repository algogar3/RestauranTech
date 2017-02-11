/*
 * Controlador que tiene como funci�n devolver un ArrayList con 
 * informaci�n de cada producto, para mostrarla en un men� 
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
	
	// M�todo obtenerListaProductos()
	public static ArrayList<Producto> obtenerListaProductos(Session session){
		// Inicializaci�n de variables
		listaProductos = new ArrayList<Producto>();
		
		// Se recuperan todos los productos de la base de datos 
		Iterator iter = session.createQuery("from Producto").iterate();
		while(iter.hasNext()){
			Producto producto = (Producto) iter.next();
			listaProductos.add(producto);
		}
		
		// Retorno del m�todo
		return listaProductos;
	}
}
