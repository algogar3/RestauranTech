package vistas;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Scrollable;

public class PanelLogo extends JPanel {
	
	// Constructor
	public PanelLogo(){
		iniciarLogo();
		setPreferredSize(new Dimension(590,590));
		setVisible(true);
	}
	
	public void iniciarLogo(){
		JLabel labelLogo = new JLabel(new ImageIcon("img/logo.jpg"));
		add(labelLogo);
	}


}
