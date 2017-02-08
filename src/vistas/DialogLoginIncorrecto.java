package vistas;

import javax.swing.JOptionPane;

public class DialogLoginIncorrecto extends JOptionPane {
	
	// Constructor
	public DialogLoginIncorrecto(){
		iniciarGUI();
	}
	
	// Método iniciarGUI()
	private void iniciarGUI(){
		showConfirmDialog(this, "Id o constraseña incorrectos", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
	}

}
