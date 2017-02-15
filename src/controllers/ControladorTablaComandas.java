package controllers;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;

import models.Comanda;
import models.Producto;

public class ControladorTablaComandas extends AbstractTableModel {
	
	// Variables
	private Object[][] valores;
	private Class[] tipos = {Integer.class, String.class};
	
	private ArrayList<Comanda> comandaLista;
	
	// Constructor
	public ControladorTablaComandas(Session session, int idServicio){
		super();
		session.beginTransaction();
		Query query = session.createQuery("from Comanda where id_servicio = '" + idServicio + "'");
		comandaLista = new ArrayList<Comanda>(query.list());
	}
	
	@Override
	public int getRowCount() {
		// Obtenemos el número de filas
		return comandaLista.size();
	}
	
	
	@Override
	public int getColumnCount() {
		// Obtenemos el número de columnas
		return tipos.length;
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		Comanda comanda = comandaLista.get(row);
		Object[] values = new Object[]{
				comanda.getCantidad(),
				comanda.getProducto().getDenominacion()
		};
		return values[column];
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		String [] columnNames = new String[]{
				"CANTIDAD",
				"PRODUCTO"
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
