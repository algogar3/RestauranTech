package vistas;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import controllers.ControladorBotonMesa;

public class PanelIzquierdo extends JPanel {
	// Variables
	private ArrayList<Integer> arrayIdMesas;
	
	// Constructor
	public PanelIzquierdo(){
		iniciarPanelIzquierdo();
		this.setVisible(true);
	}
	
	// Método iniciarPanelIzquierdo
	public void iniciarPanelIzquierdo(){
		setLayout(new GridLayout(2,3,100,100));
		// ArrayList para almacenar los id de las mesas guardadas en la base de datos
		arrayIdMesas = ControladorBotonMesa.devolverIdMesa(FramePrincipal.session);
		
		// Bucle para generar tantos botones como mesas existan en la base de datos
		for(int i=0; i<arrayIdMesas.size(); i++){
			BotonMesa nuevoBotonMesa = new BotonMesa();
			nuevoBotonMesa.setIdBotonMesa(arrayIdMesas.get(i));
			add(nuevoBotonMesa);
		}
		// Se le aplica un color de fondo al panel
		setBackground(new Color(206, 227, 246));
	}
}
