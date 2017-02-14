package controllers;

import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;

import models.Producto;

public class ControladorTablaProductos extends DefaultTableModel {
	
	// Variables
	private Object[][] valores;
	private Class[] tipos = {String.class, String.class, Double.class, String.class};
	
	// Constructor
	public ControladorTablaProductos(Session session, String tipoProducto){
		String[] campos = {"DENOMINACI�N", "TIPO PRODUCTO", "PRECIO", "DESCRIPCI�N"};
		rellenarTabla(session, tipoProducto);
		setDataVector(rellenarTabla(session, tipoProducto), campos);
	}
	
	// M�tedo rellenarTabla()
	private Object[][] rellenarTabla(Session session, String tipoProducto){
		
		// Variables
		Object[][] matrizProducto;
		ArrayList<ArrayList<Object>> arrayListContenedorValores = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> arrayProvisional = new ArrayList<Object>();
		
		// Comienzo de la transacci�n
		session.beginTransaction();
		
		// Se obtienen los datos de la tabla
		Iterator iter = session.createQuery("from Producto where tipo_producto = '" + tipoProducto + "'").iterate();
		while(iter.hasNext()){
			// Se borra todo el contenido previo del arrayProvisional
			arrayProvisional.clear();
			
			// Se rellena con contenido el arrayProvisional
			Producto producto = (Producto) iter.next();
			arrayProvisional.add(producto.getDenominacion());
			arrayProvisional.add(producto.getTipoProducto());
			arrayProvisional.add(producto.getPrecio());
			arrayProvisional.add(producto.getDescripcion());
			
			// Se a�ade el array provisional al arrayListContenedorValores
			arrayListContenedorValores.add(arrayProvisional);
		}
		
		// Instanciaci�n de la matriz retorno del m�todo
		matrizProducto = new Object[arrayListContenedorValores.size()][arrayProvisional.size()];
		
		// Se rellena la con los valores obtenidos en el bucle while anterior
		for(int i = 0; i < arrayListContenedorValores.size(); i++){
			for(int j = 0; j < arrayProvisional.size(); j++){
				matrizProducto[i][j] = arrayListContenedorValores.get(i).get(j);
			}
		}

		// Retorno del m�todo
		return matrizProducto;
	}
	
	
	public Class getColumnClass(int indice){
		return tipos[indice];
	}
	
	public boolean isCellEditable(int i, int j){
		return true;
	}
}
