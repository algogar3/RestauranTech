package vistas;

import javax.swing.JOptionPane;

public class DialogMesaCerrada extends JOptionPane{
	
	// Constructor
	public DialogMesaCerrada(int idBotonMesa){
		iniciarGUI(idBotonMesa);
	}
		
	// M�todo iniciarGUI()
	private void iniciarGUI(int idBotonMesa){
		showMessageDialog(this, "�La mesa " + idBotonMesa + " est� cerrada!", "Error", JOptionPane.WARNING_MESSAGE);
	}

}
