package vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ControladorBotonMesa;

public class PanelIzquierdo extends JPanel {
	// Variables
	private ArrayList<Integer> arrayIdMesas;
	
	// Constructor
	public PanelIzquierdo(){
		iniciarPanelIzquierdo();
		this.setVisible(true);
	}
	
	public void iniciarPanelIzquierdo(){
		setLayout(new GridLayout(2,3,100,100));
		arrayIdMesas = ControladorBotonMesa.devolverIdMesa(FramePrincipal.session);
		
		for(int i=0; i<arrayIdMesas.size(); i++){
			BotonMesa nuevoBotonMesa = new BotonMesa();
			nuevoBotonMesa.setIdBotonMesa(arrayIdMesas.get(i));
			add(nuevoBotonMesa);
		}
		
		setBackground(Color.BLUE);
		
		
	}

}
