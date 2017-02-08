package vistas;

import javax.swing.JOptionPane;

public class DiaologMesaAbierta extends JOptionPane {
	
	// Constructor
	public DiaologMesaAbierta(int idBotonMesa){
		iniciarGUI(idBotonMesa);
	}
	
	// M�todo iniciarGUI()
	private void iniciarGUI(int idBotonMesa){
		showMessageDialog(this, "�La mesa " + idBotonMesa + " ya est� abierta!", "Error", JOptionPane.WARNING_MESSAGE);
	}

}
