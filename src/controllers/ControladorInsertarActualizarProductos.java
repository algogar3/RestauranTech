/*
 * Controlador que tiene como función introducir un nuevo 
 * producto en la base de datos, o bien actualizar los 
 * atributos de un producto ya existente
 * */

package controllers;

import org.hibernate.Session;

import models.Producto;

public class ControladorInsertarActualizarProductos {
	
	public static void realizarTransaccionProducto(Session session, Producto productoTemporal, boolean creandoProducto, Integer idProducto){
		
		// Se inicia la transacción
		session.beginTransaction();
		
		// Se comprueba el tipo de operación que se debe hacer
		if(creandoProducto){
			// Se debe introducir el empleado recibido en la base de datos
			session.persist(productoTemporal);
		}
		else{
			// Hay que actualizar un empleado existente en la base de datos
			// Se recupera de la base de datos el empleado con el id igual al id pasado como parámetro
			Producto producto = (Producto) session.get(Producto.class, idProducto);
			
			// Se introducen los nuevos valores en el empleado recuperado de la base de datos
			producto.setDenominacion(productoTemporal.getDenominacion());
			producto.setTipoProducto(productoTemporal.getTipoProducto());
			producto.setPrecio(productoTemporal.getPrecio());
			producto.setDescripcion(productoTemporal.getDescripcion());

			
			// Actualización del empleado
			session.update(producto);
		}
		
		// Persistencia de los datos
		session.getTransaction().commit();
	}
}
