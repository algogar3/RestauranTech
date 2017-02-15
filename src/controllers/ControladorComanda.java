package controllers;

import java.math.BigDecimal;
import java.util.Iterator;

import org.hibernate.Session;

import models.Comanda;
import models.Producto;
import models.Servicio;
import vistas.FramePrincipal;

public class ControladorComanda {
	
	// Constructor
	public static void crearComanda(Session session, int idMesa, String nombreProducto, int cantidadProducto){
		
		// Variables
		double gastoMesaActualizado = 0.0;
		
		// Inicio de sesión
		session.beginTransaction();
		
		// Se recupera el producto cuyo nombre es igual al pasado como parámetro
		Iterator iter = session.createQuery("from Producto where denominacion = '" + nombreProducto + "'").iterate();
		Producto producto = (Producto) iter.next();
		
		// Se recupera el servicio asociado a la mesa
		Servicio servicio = ControladorServicioActivoMesa.obtenerServicioActivoMesa(FramePrincipal.session, idMesa);
		
		// Se genera una nueva comanda y se setean sus valores
		Comanda comanda = new Comanda();
		comanda.setServicio(servicio);
		comanda.setProducto(producto);
		comanda.setCantidad(cantidadProducto);
		
		// Se guardan las modificaciones en la base de datos
		session.persist(comanda);
		session.getTransaction().commit();
		
		// Inicio de una nueva transacción
		session.beginTransaction();
		
		// Se acutaliza el valor del gasto en la tabla servicio
		// Para ello se recuperan todas las comandas del servicio con el que estamos trabajando
		Iterator iter2 = session.createQuery("from Comanda where id_servicio = " + servicio.getIdServicio()).iterate();
		while(iter2.hasNext()){
			Comanda comanda2 = (Comanda) iter2.next();
			gastoMesaActualizado += comanda2.getProducto().getPrecio().doubleValue() * comanda2.getCantidad();
			System.out.println("El gasto en este punto es de " + gastoMesaActualizado);
		}
		
		System.out.println(gastoMesaActualizado);
		
		// Se setea el gasto actualizado en el servicio
		servicio.setGasto(new BigDecimal(gastoMesaActualizado));
		
		session.update(servicio);
		session.getTransaction().commit();
	}

}
