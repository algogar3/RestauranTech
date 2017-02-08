package vistas;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelLogo extends JPanel {
	
	// Constructor
	public PanelLogo(){
		iniciarLogo();
		this.setVisible(true);
	}
	
	public void iniciarLogo(){
		JLabel labelLogo = new JLabel(new ImageIcon("img/logo.jpg"));
		add(labelLogo);
	}

}
