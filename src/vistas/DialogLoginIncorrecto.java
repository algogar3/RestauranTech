package vistas;

import javax.swing.JOptionPane;

public class DialogLoginIncorrecto extends JOptionPane {
	
	// Constructor
	public DialogLoginIncorrecto(){
		iniciarGUI();
	}
	
	// M�todo iniciarGUI()
	private void iniciarGUI(){
		showConfirmDialog(this, "Id o constrase�a incorrectos", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
	}

}
