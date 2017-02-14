package controllers;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;

import models.Producto;

public class ControladorTablaProductos extends AbstractTableModel {
	
	// Variables
	private Object[][] valores;
	private Class[] tipos = {String.class, String.class, Double.class, String.class};
	
	private ArrayList<Producto> productoLista;
	
	// Constructor
	public ControladorTablaProductos(Session session, String tipoProducto){
		super();
		session.beginTransaction();
		Query query = session.createQuery("from Producto where tipo_producto = '" + tipoProducto + "'");
		productoLista = new ArrayList<Producto>(query.list());
	}
	
	@Override
	public int getRowCount() {
		// Obtenemos el número de filas
		return productoLista.size();
	}
	
	
	@Override
	public int getColumnCount() {
		// Obtenemos el número de columnas
		return tipos.length;
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		Producto producto = productoLista.get(row);
		Object[] values = new Object[]{
				producto.getDenominacion(),
				producto.getTipoProducto(),
				producto.getPrecio(),
				producto.getDescripcion()
		};
		return values[column];
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		String [] columnNames = new String[]{
				"DENOMINACIÓN",
				"TIPO PRODUCTO",
				"PRECIO",
				"DESCRIPCIÓN"
		};
		return columnNames[column];
	}
	
	
	public Class getColumnClass(int indice){
		return tipos[indice];
	}
	
	public boolean isCellEditable(int i, int j){
		return false;
	}
}
