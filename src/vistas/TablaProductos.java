package vistas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;

import controllers.ControladorTablaProductos;

public class TablaProductos extends JTable implements TableModelListener, MouseListener{
	
	// Constantes
	private final String KEY_COMIDA = "comida";
	private final String KEY_BEBIDA = "bebida";
	private final String KEY_POSTRE = "postre";
	
	// Variables
	private JLabel labelDenominacion;
	private JLabel labelTipoProducto;
	private JLabel labelPrecio;
	private JLabel labelDescripcion;
	private JTextField campoDenominacion;
	private JTextField campoTipoProducto;
	private JTextField campoPrecio;
	private JTextField campoDescripcion;
	private ControladorTablaProductos modeloTabla;
	
	// Constructor
	public TablaProductos(String tipoProducto){
		iniciarGUI(tipoProducto);
	}
	
	// Método iniciarGUI
	private void iniciarGUI(String tipoProducto){
		
		// Nuevo modelo
		modeloTabla = new ControladorTablaProductos(FramePrincipal.session, tipoProducto);
		
		// Se crea un JTable
		//tablaFutbol = new JTable(modeloTabla);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
