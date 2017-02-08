package vistas;

import javax.swing.JOptionPane;

public class DialogLoginIncorrecto extends JOptionPane {
	
	// Constructor
	public DialogLoginIncorrecto(){
		iniciarGUI();
	}
	
	// Método iniciarGUI()
	private void iniciarGUI(){
		showConfirmDialog(this, "Constraseña incorrecta!!", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
	}
}
