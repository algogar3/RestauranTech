package vista;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPad extends JPanel {
	
	// Constructor
	public PanelPad(){
		iniciarPad();
		this.setVisible(true);
	}
	
	public void iniciarPad(){
		JLabel labelLogo = new JLabel(new ImageIcon("img/prueba.jpg"));
		add(labelLogo);
	}

}
