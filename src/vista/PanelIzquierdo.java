package vista;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelIzquierdo extends JPanel {
	
	// Constructor
	public PanelIzquierdo(){
		iniciarPanelIzquierdo();
		this.setVisible(true);
	}
	
	public void iniciarPanelIzquierdo(){
		setLayout(new GridLayout(2,3,100,100));
		
		for(int i=0; i<6; i++){
			add(new BotonMesa());
		}
		
		setBackground(Color.BLUE);
		
		
	}

}
