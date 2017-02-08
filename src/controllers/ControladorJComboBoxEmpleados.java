/*
 * Controlador que tiene como funci�n devolver un ArrayList con 
 * informaci�n de cada empleado, para mostrarla en un men� desplegable 
 * (JComboBox)
 * */

package controllers;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;

import models.Empleado;

public class ControladorJComboBoxEmpleados {
	
	// Variables
	private static ArrayList<Empleado> listaEmpleados;
	
	// M�todo obtenerListaEmpleados()
	public static ArrayList<Empleado> obtenerListaEmpleados(Session session){
		// Inicializaci�n de variables
		listaEmpleados = new ArrayList<Empleado>();
		
		// Se recuperan todos los empleados de la base de datos 
		Iterator iter = session.createQuery("from Empleado").iterate();
		while(iter.hasNext()){
			Empleado empleado = (Empleado) iter.next();
			listaEmpleados.add(empleado);
		}
		
		// Retorno del m�todo
		return listaEmpleados;
	}
}
